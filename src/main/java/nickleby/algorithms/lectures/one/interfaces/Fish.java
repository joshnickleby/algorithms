package nickleby.algorithms.lectures.one.interfaces;

public interface Fish extends Creature {

    @Override
    default void giveBirth() {
        System.out.println(name + " lays a bunch of eggs and leaves them to hatch later.");
    }
}
