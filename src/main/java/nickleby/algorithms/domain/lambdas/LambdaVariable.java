package nickleby.algorithms.domain.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaVariable implements Runnable {

    final static String FG_RED = (char)27 + "[31m";
    final static String FG_GREEN = (char)27 + "[32m";

    private static void sharedRoutine(Function<String, String> function, String testString, String expectedString) {
        testString = function.apply(testString);
        boolean correct = testString.equals(expectedString);
        System.out.println((correct ? FG_GREEN : FG_RED + " IN") + "CORRECT: " + testString);
        if(!correct) { System.out.println("\t\tExpected: " + expectedString + " Actual: " + testString); }
    }

    private static void reverse(Function<String, String> function) {
        sharedRoutine(function,"budbudabulabuw", "wubalubadubdub");
    }

    private static void countCharacters(Function<String, String> function) {
        sharedRoutine(function,"abcdefghijklmnoqrstuvwxyz", "25");
    }

    private static void doubleCharacters(Function<String, String> function) {
        sharedRoutine(function,"1234567890", "11223344556677889900");
    }


    /** make these pass by only changing the function variable within main -- ANSWER **/
    @Override
    public void run() {
        //change this to reverse the string
        Function<String, String> function = (s) -> {
            List<String> split = Arrays.asList(s.split(""));

            Collections.reverse(split);

            return split.stream().collect(Collectors.joining());
        };

        reverse(function);

        //change the function to count the characters
        function = (s) -> Long.toString(Stream.of(s.split("")).count());

        countCharacters(function);

        //change the function to double the characters
        function = (s) -> Stream.of(s.split("")).map(st -> st + st).collect(Collectors.joining());

        doubleCharacters(function);
    }
}
