package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.Fish;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.UUID;

public class Shark extends Animal implements Fish, WaterBased {

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