package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.Mammal;

import java.util.UUID;

public class Bear extends Animal implements Mammal, LandBased {

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
