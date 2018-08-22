package nickleby.algorithms.lectures.one.interfaces;

public interface Reptile extends Creature {

    @Override
    default void giveBirth() {
        System.out.println(name + " lays eggs and protects them from predators.");
    }
}
