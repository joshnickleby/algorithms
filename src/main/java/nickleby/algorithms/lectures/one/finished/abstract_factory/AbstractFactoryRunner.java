package nickleby.algorithms.lectures.one.finished.abstract_factory;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.domain.*;
import nickleby.algorithms.lectures.one.finished.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class AbstractFactoryRunner {

    private static class MammalFactory implements AnimalAbstractFactory<Mammal> {
        private List<Supplier<Mammal>> generators = Arrays.asList(Bear::new, Rabbit::new, Dolphin::new);

        @Override
        public Mammal createAnimal() {
            return generators.get(random.nextInt(3)).get();
        }

        @Override
        public LandBased createLandBasedAnimal() {
            return (LandBased) generators.get(random.nextInt(2)).get();
        }

        @Override
        public WaterBased createWaterBasedAnimal() {
            return new Dolphin();
        }
    }

    private static class ReptileFactory implements AnimalAbstractFactory<Reptile> {

        private List<Supplier<Reptile>> generators = Arrays.asList(Snake::new, Turtle::new);

        private Reptile getRandomReptile() { return generators.get(random.nextInt(2)).get(); }

        @Override
        public Reptile createAnimal() {
            return getRandomReptile();
        }

        @Override
        public LandBased createLandBasedAnimal() {
            return (LandBased) getRandomReptile();
        }

        @Override
        public WaterBased createWaterBasedAnimal() {
            return (WaterBased) getRandomReptile();
        }
    }

    public static void main(String[] args) {
        List<AnimalAbstractFactory> factories = Arrays.asList(new MammalFactory(), new ReptileFactory());

        Consumer<Creature> printInfo = creature ->
            System.out.println("Created a " + creature.getClass().getSimpleName() + ": " + creature.id());

        System.out.println("CODED EXAMPLE");

        factories.forEach(factory -> {
            Creature animal = factory.createAnimal();
            printInfo.accept(animal);

            LandBased landAnimal = factory.createLandBasedAnimal();
            printInfo.accept((Creature) landAnimal);

            WaterBased waterAnimal = factory.createWaterBasedAnimal();
            printInfo.accept((Creature) waterAnimal);
        });

        System.out.println("LAMBDA EXAMPLE");

        List<Function<AnimalAbstractFactory, Creature>> creators = Arrays.asList(
            AnimalAbstractFactory::createAnimal,
            factory -> (Creature) factory.createLandBasedAnimal(),
            factory -> (Creature) factory.createWaterBasedAnimal()
        );

        BiConsumer<AnimalAbstractFactory, Integer> createAnimalAndDisplay = (factory, i) ->
            printInfo.accept(creators.get(i).apply(factory));


        factories.forEach(factory -> IntStream.range(0, creators.size()).boxed()
                                                                        .forEach(i -> createAnimalAndDisplay.accept(factory, i)));
    }
}
