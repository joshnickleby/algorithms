package nickleby.algorithms.lectures.one.interfaces;

public interface Creature {

    default void breathe() {
        System.out.println("It takes a breath in of oxygen from the air.");
        System.out.println("It takes a breath out of oxygen from the air.");
    }

    void giveBirth();

    void move();

    default void setDifferences() {}
}
