package nickleby.algorithms.lectures.one.finished;

import nickleby.algorithms.lectures.one.finished.domain.*;

import java.util.Arrays;
import java.util.List;

public class LectureOne {


    public static void main(String[] args) {
        Ocean ocean = new Ocean(new Shark("Tiger"));
        Forest forest = new Forest(new Bear("Brown"));
        Zoo zoo = new Zoo(new Bear("Black"));


        List<Geosphere> envs = Arrays.asList(ocean, forest, zoo);

        envs.forEach(Geosphere::watch);
    }
}
