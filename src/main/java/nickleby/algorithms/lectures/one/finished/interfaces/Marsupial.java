package nickleby.algorithms.lectures.one.finished.interfaces;

public interface Marsupial extends Creature {

    @Override
    default void giveBirth() {
        System.out.println("It does something weird");
    }
}
