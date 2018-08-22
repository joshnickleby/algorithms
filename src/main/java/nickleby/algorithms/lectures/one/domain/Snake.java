package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Reptile;

import java.util.UUID;

public class Snake extends Animal implements Reptile {

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
        this.numberOfLegs(0);
        this.skinType("Scales");
    }
}