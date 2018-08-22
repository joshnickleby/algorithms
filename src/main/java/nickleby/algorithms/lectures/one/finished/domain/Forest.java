package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.List;


public class Forest extends EnvironmentArea<Forest, LandBased> {

    public Forest(LandBased ... animals) { super(Forest.class, animals); }

    public Forest(List<LandBased> animals) { super(Forest.class, animals); }
}
