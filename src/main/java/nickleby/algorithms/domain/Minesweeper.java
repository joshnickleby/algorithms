package nickleby.algorithms.domain;

import nickleby.algorithms.utils.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Minesweeper implements Runnable {

    private final static Boolean[][] TEST_1 = {{true, false, false},
                                               {false, true, false},
                                               {false, false, false}};

    private final static Integer[][] EXPECT_1 = {{1, 2, 1},
                                                 {2, 1, 1},
                                                 {1, 1, 1}};

    private final static Boolean[][] TEST_2 = {{true, true, true, true},
                                               {true, true, true, true},
                                               {true, true, true, true}};

    private final static Integer[][] EXPECT_2 = {{3, 5, 5, 3},
                                                 {5, 8, 8, 5},
                                                 {3, 5, 5, 3}};


    private static class MatrixMap extends HashMap<Integer, Map> {

        public MatrixMap(int startRange, int endRange) {
            this.putAll(IntStream.range(startRange, endRange).boxed()
                    .collect(Collectors.toMap(i -> i,
                            i -> IntStream.range(0, 5).boxed()
                                    .collect(Collectors.toMap(j -> j, j -> 0)))));
        }

        public MatrixMap addOne(int mapIndex, int itemIndex) {
            this.get(mapIndex).put(itemIndex, (Integer) this.get(mapIndex).get(itemIndex) + 1);

            return this;
        }

        public MatrixMap addAround(int x, int y) {
            for(int i = x-1; i < x+2; i++) {
                for(int j = y-1; j < y+2; j++) {
                    if(!(i == x && j == y)) {
                        this.addOne(i, j);
                    }
                }
            }

            return this;
        }
    }


    private void doWithForLoops(Boolean[][] matrix) {

        MatrixMap matrixMap = new MatrixMap(0, 5);

        Integer[][] fin = new Integer[matrix.length][matrix[0].length];

        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;

        for(int x = top; x < bottom; x++) {
            Boolean[] row = matrix[x];

            for(int y = left; y < right; y++) {
                if(row[y]) { matrixMap.addAround(x+1, y+1); }
            }
        }

        for(int x = top; x < bottom; x++) {
            for(int y = left; y < right; y++) {
                fin[x][y] = (Integer) matrixMap.get(x+1).get(y+1);
            }
        }

        PrintUtil.printMap(matrixMap);
        PrintUtil.print2dArray(fin);
    }


    @Override
    public void run() {
        doWithForLoops(TEST_1);
    }
}
