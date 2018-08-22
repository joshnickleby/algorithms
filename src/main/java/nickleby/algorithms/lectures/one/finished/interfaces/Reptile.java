package nickleby.algorithms.lectures.one.finished.interfaces;

public interface Reptile extends Creature {

    @Override
    default void giveBirth() {
        System.out.println("It lays eggs and protects them from predators.");
    }
}
