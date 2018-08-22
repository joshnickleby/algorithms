package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.Reptile;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.UUID;

public class Turtle extends Animal implements Reptile, LandBased, WaterBased {

    public Turtle() {
        super(UUID.randomUUID());
    }

    public Turtle(String type) {
        super(UUID.randomUUID(), type, FoodSource.HERBIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("It slowly hobbles along");
    }

    @Override
    public void setDifferences() {
        super.skinType("Shell and scales");
    }
}