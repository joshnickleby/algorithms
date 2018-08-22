package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;


public class Forest extends EnvironmentArea<Forest, LandBased> {

    public Forest(LandBased ... animals) { super(Forest.class, animals); }
}
