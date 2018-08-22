package nickleby.algorithms.lectures.one.finished.interfaces;

public interface Creature {

    default void breathe() {
        System.out.println("It breathes oxygen from the air.");
    }

    void giveBirth();

    void move();

    default void setDifferences() {}
}
