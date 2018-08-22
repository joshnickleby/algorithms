package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.Marsupial;

import java.util.UUID;

public class Kangaroo extends Animal implements Marsupial, LandBased {

    public Kangaroo() {
        super(UUID.randomUUID());
    }

    public Kangaroo(String type) {
        super(UUID.randomUUID(), type, FoodSource.HERBIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("It hops around.");
    }
}