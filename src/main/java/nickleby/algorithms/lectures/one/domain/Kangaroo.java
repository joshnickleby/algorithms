package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Marsupial;

import java.util.UUID;

public class Kangaroo extends Animal implements Marsupial {

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