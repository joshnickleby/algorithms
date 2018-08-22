package nickleby.algorithms.lectures.one.finished;

import nickleby.algorithms.lectures.one.SeedData.SeedData;
import nickleby.algorithms.lectures.one.finished.domain.*;
import nickleby.algorithms.lectures.one.finished.interfaces.Creature;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LectureOne {


    public static void main(String[] args) {

        List<WaterBased> waterAnimals = new ArrayList<>();
        waterAnimals.addAll(SeedData.getSharks());
        waterAnimals.addAll(SeedData.getSnakes());
        waterAnimals.addAll(SeedData.getTurtles());

        List<LandBased> landAnimals = new ArrayList<>();
        landAnimals.addAll(SeedData.getTurtles());
        landAnimals.addAll(SeedData.getSnakes());
        landAnimals.addAll(SeedData.getBears());
        landAnimals.addAll(SeedData.getKangaroos());
        landAnimals.addAll(SeedData.getRabbits());

        List<Creature> creatures = new ArrayList<>();
        creatures.addAll(waterAnimals.stream().map(Creature.class::cast).collect(Collectors.toList()));
        creatures.addAll(landAnimals.stream().map(Creature.class::cast).collect(Collectors.toList()));

        Ocean ocean = new Ocean(waterAnimals);
        Forest forest = new Forest(landAnimals);
        Zoo zoo = new Zoo(creatures);


        List<Geosphere> envs = Arrays.asList(ocean, forest, zoo);

        envs.forEach(Geosphere::watch);
    }
}
