package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.Mammal;

import java.util.UUID;

public class Rabbit extends Animal implements Mammal, LandBased {

    public Rabbit() {
        super(UUID.randomUUID());
    }

    public Rabbit(String type) {
        super(UUID.randomUUID(), type, FoodSource.HERBIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("It hops along the ground.");
    }
}