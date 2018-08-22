package nickleby.algorithms.lectures.one.interfaces;

public interface Mammal extends Creature {

    @Override
    default void giveBirth() {
        System.out.println("It births a live baby.");
    }
}
