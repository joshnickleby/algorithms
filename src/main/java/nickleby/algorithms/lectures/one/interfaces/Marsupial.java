package nickleby.algorithms.lectures.one.interfaces;

public interface Marsupial extends Creature {

    @Override
    default void giveBirth() {
        System.out.println("It does something weird");
    }
}
