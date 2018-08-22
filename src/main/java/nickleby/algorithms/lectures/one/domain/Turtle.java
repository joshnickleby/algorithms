package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Reptile;

import java.util.UUID;

public class Turtle extends Animal implements Reptile {

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
        this.skinType("Shell and scales");
    }
}