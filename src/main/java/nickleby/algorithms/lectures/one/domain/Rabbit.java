package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Mammal;

import java.util.UUID;

public class Rabbit extends Animal implements Mammal {

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