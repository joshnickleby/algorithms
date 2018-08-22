package nickleby.algorithms.lectures.one.finished.interfaces;

public interface Fish extends Creature {

    @Override
    default void breathe() {
        System.out.println("It breathes in water and filters out the oxygen.");
    }

    @Override
    default void giveBirth() {
        System.out.println("It lays a bunch of eggs and leaves them to hatch later.");
    }
}
