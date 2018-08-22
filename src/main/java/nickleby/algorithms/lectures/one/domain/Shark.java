package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Fish;

import java.util.UUID;

public class Shark extends Animal implements Fish {

    public Shark() {
        super(UUID.randomUUID());
    }

    public Shark(String type) {
        super(UUID.randomUUID(), type, FoodSource.CARNIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("Swims quickly through the water.");
    }

    @Override
    public void setDifferences() {
        this.numberOfLegs(0);
        this.skinType("Scales");
    }
}