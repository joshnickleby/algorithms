package nickleby.algorithms.lectures.one.interfaces;

public interface Creature {

    String name = "Unknown";

    default void breathe() {
        System.out.println(name + " takes a breath in of oxygen from the air.");
        System.out.println(name + " takes a breath out of oxygen from the air.");
    }

    void giveBirth();

    void move();
}
