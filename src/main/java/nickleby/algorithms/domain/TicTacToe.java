package nickleby.algorithms.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicTacToe {

    final static String TEST1 = "xxxxoxoxo";
    final static String TEST2 = "xxoxxxoxo";
    final static String TEST3 = "xxoxooooo";
    final static String TEST4 = "xxoxoxxxo";
    final static String TEST5 = "oxoxxooxx";
    final static String TEST6 = "ooxxoxoxx";
    final static String TEST7 = "xxooxxxox";
    final static String TEST8 = "oxxxxoxoo";
    final static String TEST9 = "xxxxoxooo";

    static List<String> TEST_STRINGS = Arrays.asList(TEST1, TEST2, TEST3, TEST4, TEST5, TEST6, TEST7, TEST8, TEST9);

    static Function<String, String> CHECK_GRID = s -> s.equals("xxx") ? "x" : s.equals("ooo") ? "o" : "";

    static Function<String, String> TOP_ROW = s -> s.substring(0, 3);
    static Function<String, String> MIDDLE_ROW = s -> s.substring(3, 6);
    static Function<String, String> BOTTOM_ROW = s -> s.substring(6, 9);

    static Function<String, String> LEFT_COLUMN = s -> {
        String [] split = s.split("");
        return split[0] + split[3] + split[6];
    };

    static Function<String, String> MIDDLE_COLUMN = s -> {
        String [] split = s.split("");
        return split[1] + split[4] + split[7];
    };

    static Function<String, String> RIGHT_COLUMN = s -> {
        String [] split = s.split("");
        return split[2] + split[5] + split[8];
    };

    static Function<String, String> TOP_LEFT_TO_BOTTOM_RIGHT = s -> {
        String [] split = s.split("");
        return split[0] + split[4] + split[8];
    };

    static Function<String, String> TOP_RIGHT_TO_BOTTOM_LEFT = s -> {
        String [] split = s.split("");
        return split[2] + split[4] + split[6];
    };

    static List<Function<String, String>> FUNCTIONS = Arrays.asList(
            TOP_ROW, MIDDLE_ROW, BOTTOM_ROW, LEFT_COLUMN, MIDDLE_COLUMN, RIGHT_COLUMN, TOP_LEFT_TO_BOTTOM_RIGHT, TOP_RIGHT_TO_BOTTOM_LEFT
    );

    static String checkTicTacToe(String grid) {
        String finalString = FUNCTIONS.stream().map(fn -> CHECK_GRID.apply(fn.apply(grid))).collect(Collectors.joining());

        return finalString.equals("") || finalString.contains("xo") || finalString.contains("ox") ? "DRAW" : finalString.substring(0,1);
    }


    public static void main(String[] args) {
        TEST_STRINGS.forEach(ts -> {
            String answer = checkTicTacToe(ts);

            System.out.println(answer);
        });

    }
}
