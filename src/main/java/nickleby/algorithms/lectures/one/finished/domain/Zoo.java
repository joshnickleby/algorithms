package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.interfaces.Creature;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

public class Zoo extends EnvironmentArea<Zoo, Creature> {

    public Zoo(Creature... animals) { super(Zoo.class, animals); }
}
