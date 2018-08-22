package nickleby.algorithms.lectures.one.SeedData;

import nickleby.algorithms.lectures.one.finished.domain.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeedData {

    public static List<Bear> getBears() {
        return Stream.of("Brown", "Black", "Grizzly", "Polar", "Sun").map(Bear::new).collect(Collectors.toList());
    }

    public static List<Kangaroo> getKangaroos() {
        return Stream.of("Red", "Grey", "Grey", "Red", "Grey").map(Kangaroo::new).collect(Collectors.toList());
    }

    public static List<Rabbit> getRabbits() {
        return Stream.of("Grey", "Roger", "Floppy").map(Rabbit::new).collect(Collectors.toList());
    }

    public static List<Shark> getSharks() {
        return Stream.of("Tiger", "Great White", "Hammerhead", "Cookie Cutter", "Whale").map(Shark::new).collect(Collectors.toList());
    }

    public static List<Snake> getSnakes() {
        return Stream.of("Cobra", "Boa Constrictor", "Anaconda", "Rattle").map(Snake::new).collect(Collectors.toList());
    }

    public static List<Turtle> getTurtles() {
        return Stream.of("Box", "Painted", "Sea", "Teenage Mutant Ninja").map(Turtle::new).collect(Collectors.toList());
    }
}
