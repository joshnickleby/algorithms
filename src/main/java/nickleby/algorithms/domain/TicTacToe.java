package nickleby.algorithms.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicTacToe {

    //region TESTS

    final static private String TEST1 = "xxxxoxoxo";
    final static private String TEST2 = "xxoxxxoxo";
    final static private String TEST3 = "xxoxooooo";
    final static private String TEST4 = "xxoxoxxxo";
    final static private String TEST5 = "oxoxxooxx";
    final static private String TEST6 = "ooxxoxoxx";
    final static private String TEST7 = "xxooxxxox";
    final static private String TEST8 = "oxxxxoxoo";
    final static private String TEST9 = "xxxxoxooo";

    static private List<String> TEST_STRINGS = Arrays.asList(TEST1, TEST2, TEST3, TEST4, TEST5, TEST6, TEST7, TEST8, TEST9);

    //endregion TESTS


    //region TRANSFORMATION METHODS
    static private String transform(String s, int start, int increment) {
        String [] split = s.split("");
        return split[start] + split[start+increment] + split[start+(increment*2)];
    }

    static private String makeColumn(String s, int start) { return transform(s, start, 3); }

    //endregion TRANSFORMATION METHODS


    //region FUNCTIONS

    static private UnaryOperator<String> CHECK_GRID = s -> s.equals("xxx") ? "x" : s.equals("ooo") ? "o" : "";

    static private UnaryOperator<String> TOP_ROW    = s -> s.substring(0, 3);
    static private UnaryOperator<String> MIDDLE_ROW = s -> s.substring(3, 6);
    static private UnaryOperator<String> BOTTOM_ROW = s -> s.substring(6, 9);

    static private UnaryOperator<String> LEFT_COLUMN   = s -> makeColumn(s, 0);
    static private UnaryOperator<String> MIDDLE_COLUMN = s -> makeColumn(s, 1);
    static private UnaryOperator<String> RIGHT_COLUMN  = s -> makeColumn(s, 2);

    static private UnaryOperator<String> TOP_LEFT_TO_BOTTOM_RIGHT = s -> transform(s, 0, 4);
    static private UnaryOperator<String> TOP_RIGHT_TO_BOTTOM_LEFT = s -> transform(s, 2, 2);

    static private List<UnaryOperator<String>> FUNCTIONS = Arrays.asList(
            TOP_ROW, MIDDLE_ROW, BOTTOM_ROW, LEFT_COLUMN, MIDDLE_COLUMN, RIGHT_COLUMN, TOP_LEFT_TO_BOTTOM_RIGHT, TOP_RIGHT_TO_BOTTOM_LEFT
    );

    //endregion FUNCTIONS


    //region MAIN ROUTINE

    static private String checkIfDrawOrWinner(String s) {
        return s.equals("") || s.contains("xo") || s.contains("ox") ? "DRAW" : s.substring(0,1);
    }

    static private String checkTicTacToe(String grid) {
        String finalString = FUNCTIONS.stream().map(fn -> CHECK_GRID.compose(fn).apply(grid)).collect(Collectors.joining());

        return checkIfDrawOrWinner(finalString);
    }


    public static void main(String[] args) {
        TEST_STRINGS.forEach(ts -> {
            String answer = checkTicTacToe(ts);

            System.out.println(answer);
        });
    }

    //endregion MAIN ROUTINE
    
}
