package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.Animal;
import nickleby.algorithms.lectures.one.finished.FoodSource;
import nickleby.algorithms.lectures.one.finished.interfaces.Mammal;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.UUID;

public class Dolphin extends Animal implements Mammal, WaterBased {

    public Dolphin() {
        super(UUID.randomUUID());
    }

    public Dolphin(String type) {
        super(UUID.randomUUID(), type, FoodSource.CARNIVORE.toString());
    }

    @Override
    public void move() {
        System.out.println("It swims gracefully through the water.");
    }
}
