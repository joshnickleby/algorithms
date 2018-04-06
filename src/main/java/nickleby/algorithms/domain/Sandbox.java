package nickleby.algorithms.domain;


import java.util.function.Function;

public class Sandbox {

    public static void main(String[] args) {
        Function<Integer, Integer> start = x -> {
            Integer i = x + 10;
            System.out.println("start: " + i);
            return i;
        };

        Function<Integer, Integer> inner = x -> {
            Integer i = x + 20;
            System.out.println("inner: " + i);
            return i;
        };

        Integer s = start.apply(10);

        System.out.println("First: " + s);

        Function<Integer, Integer> composedFunction = start.compose(inner);

        Integer s1 = composedFunction.apply(10);

        System.out.println("Second: " + s1);

        Function<Integer, Integer> andThenFunction = start.andThen(inner);

        Integer s2 = andThenFunction.apply(10);

        System.out.println("Third: " + s2);

        Function<Integer, Integer> identityFunction = Function.identity();

        Integer s3 = identityFunction.apply(10);

        System.out.println("Fourth: " + s3);
    }
}
