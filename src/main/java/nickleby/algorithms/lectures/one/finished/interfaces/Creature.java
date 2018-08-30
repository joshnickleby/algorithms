package nickleby.algorithms.lectures.one.finished.interfaces;

import java.util.UUID;

public interface Creature {

    UUID id();

    default void breathe() {
        System.out.println("It breathes oxygen from the air.");
    }

    void giveBirth();

    void move();

    default void setDifferences() {}
}
