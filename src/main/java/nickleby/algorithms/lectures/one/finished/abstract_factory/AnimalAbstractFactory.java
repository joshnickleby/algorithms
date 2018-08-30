package nickleby.algorithms.lectures.one.finished.abstract_factory;

import nickleby.algorithms.lectures.one.finished.interfaces.Creature;
import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.Random;

public interface AnimalAbstractFactory<T extends Creature> {
    Random random = new Random();

    T createAnimal();
    LandBased createLandBasedAnimal();
    WaterBased createWaterBasedAnimal();
}
