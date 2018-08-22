package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.Reptile;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.UUID;

public class Snake extends Animal implements Reptile, LandBased, WaterBased {

    public Snake() {
        super(UUID.randomUUID());
        setDifferences();
    }

    public Snake(String type) {
        super(UUID.randomUUID(), type, FoodSource.CARNIVORE.toString());
        setDifferences();
    }

    @Override
    public void move() {
        System.out.println("It slithers along.");
    }

    public void setDifferences() {
        super.numberOfLegs(0);
        super.skinType("Scales");
    }
}