package nickleby.algorithms.lectures.one.domain;

import nickleby.algorithms.lectures.one.Animal;
import nickleby.algorithms.lectures.one.FoodSource;
import nickleby.algorithms.lectures.one.interfaces.Mammal;

import java.util.UUID;

public class Bear extends Animal implements Mammal {

    public Bear() {
        super(UUID.randomUUID());
    }

    public Bear(String type) {
        super(UUID.randomUUID(), type, FoodSource.OMNIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("It trudges along on all fours.");
    }
}
