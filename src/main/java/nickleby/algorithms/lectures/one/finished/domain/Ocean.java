package nickleby.algorithms.lectures.one.finished.domain;

import nickleby.algorithms.lectures.one.finished.interfaces.LandBased;
import nickleby.algorithms.lectures.one.finished.interfaces.WaterBased;

import java.util.List;

public class Ocean extends EnvironmentArea<Ocean, WaterBased> {

    public Ocean(WaterBased... animals) { super(Ocean.class, animals); }

    public Ocean(List<WaterBased> animals) { super(Ocean.class, animals); }
}
