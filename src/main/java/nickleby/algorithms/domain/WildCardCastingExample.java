package nickleby.algorithms.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WildCardCastingExample {

    /** Just the top level class to use in the wildcard list **/
    private static class TopLevel {
        private Integer num;

        public TopLevel(Integer num) {
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public Integer setNum(Integer num) {
            this.num = num;
            return this.num;
        }
    }

    /**
     *  Class that extends top level using in a wildcard list.
     *  Has a different type of method.
     */
    private static class CoolDragon extends TopLevel {
        public CoolDragon(Integer num) { super(num); }

        public void yell() {
            System.out.println("I'm Cool Dragon #" + this.getNum());
        }
    }

    /**
     *  Class that extends top level using in a wildcard list.
     *  Has a different type of method.
     */
    private static class NimbleWalrus extends TopLevel {
        public NimbleWalrus(Integer num) { super(num); }

        public void bellow() {
            System.out.println("I'm number " + this.getNum() + " Nimble Walrus");
        }
    }

    private static List<CoolDragon> makeCoolDragons() {
        return IntStream.range(0, 9).boxed().map(CoolDragon::new).collect(Collectors.toList());
    }

    private static List<NimbleWalrus> makeNimbleWalruses() {
        return IntStream.range(0, 9).boxed().map(NimbleWalrus::new).collect(Collectors.toList());
    }

    /**
     *  A generic list method that takes in a list of objects that extend TopLevel
     *  and returns the same wildcard list
     *
     * @param list
     * @return
     */
    private static List<? extends TopLevel> processList(List<? extends TopLevel> list) {
        list.forEach(item -> System.out.println(item.getNum()));

        return list.stream()
                .peek(item -> item.setNum(item.getNum()+1))
                .collect(Collectors.toList());
    }


    /**
     *  1. Makes the two separate lists.
     *  2. Then processes it through the generic list processer but returns a wildcard
     *     list of objects that extend TopLevel
     *  3. Then you take the "generic" list and cast each item into the subClass in order
     *     to use the individual methods (or in some case pass it to a service to save)
     *  4. Just to confirm it worked it will call both object list's unique methods
     *
     * @param args
     */
    public static void main(String[] args) {
        List<CoolDragon> coolDragons = makeCoolDragons();
        List<NimbleWalrus> nimbleWalruses = makeNimbleWalruses();

        List<? extends TopLevel> manipulatedDragons = processList(coolDragons);
        List<? extends TopLevel> manipulatedWalruses = processList(nimbleWalruses);

        coolDragons = manipulatedDragons.stream().map(CoolDragon.class::cast).collect(Collectors.toList());
        nimbleWalruses = manipulatedWalruses.stream().map(NimbleWalrus.class::cast).collect(Collectors.toList());

        coolDragons.forEach(CoolDragon::yell);
        nimbleWalruses.forEach(NimbleWalrus::bellow);
    }
}