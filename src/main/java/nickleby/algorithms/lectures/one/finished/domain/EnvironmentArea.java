package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.interfaces.Creature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class EnvironmentArea<U, T> implements Geosphere {

    List<Creature> animals = new ArrayList<>();
    Class<U> tClass;

    protected EnvironmentArea(Class<U> tClass) {
        this.tClass = tClass;
    }

    protected EnvironmentArea(Class<U> tClass, T ... definedAnimals) {
        this(tClass);
        this.animals = Stream.of(definedAnimals).map(Creature.class::cast).collect(Collectors.toList());
    }

    protected EnvironmentArea(Class<U> tClass, List<T> definedAnimals) {
        this(tClass);
        this.animals = definedAnimals.stream().map(Creature.class::cast).collect(Collectors.toList());
    }

    @Override
    public void watch() {
        System.out.println("[!] Watching animals in the " + tClass.getSimpleName());

        this.animals.forEach(animal -> {
            Animal info = (Animal) animal;
            System.out.println(info.type() + " " + animal.getClass().getSimpleName() + " has " + info.numberOfLegs() + " legs.");
            animal.breathe();
            animal.move();
            animal.giveBirth();
            System.out.println();
        });
        System.out.println();
    }
}
