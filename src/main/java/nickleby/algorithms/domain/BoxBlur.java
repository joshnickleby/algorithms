package nickleby.algorithms.domain;

import nickleby.algorithms.utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral!
 * You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.
 *
 * The pixels in the input image are represented as integers. The algorithm distorts the input image in the
 * following way: Every pixel x in the output image has a value equal to the average value of the pixel values from
 * the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.
 *
 * Return the blurred image as an integer, with the fractions rounded down.
 */
public class BoxBlur implements Runnable {

    private final static Integer[][] TEST_1 = {{1, 1, 1},
                                               {1, 7, 1},
                                               {1, 1, 1}};

    private final static Integer[][] EXPECTED_1 = {{1}};

    private final static Integer[][] TEST_2 = {{7, 4, 0, 1},
                                               {5, 6, 2, 2},
                                               {6, 10, 7, 8},
                                               {1, 4, 2, 0}};

    private final static Integer[][] EXPECTED_2 = {{5, 4},
                                                   {4, 4}};

    private final static Integer[][] TEST_3 = {{1, 2, 3, 4, 5},
                                               {1, 2, 3, 4, 5},
                                               {1, 2, 3, 4, 5},
                                               {1, 2, 3, 4, 5}};

    private final static Integer[][] EXPECTED_3 = {{2, 3, 4}, {2, 3, 4}};

    private static BinaryOperator<Integer> getSum(Integer[][] test, Integer index) {
        return (a, i) -> a += test[index][i] + test[index+1][i] + test[index+2][i];
    }

    private static Function<Integer, Integer> getAverage(Integer[][] test, Integer index) {
        return z -> IntStream.range(z, z + 3).boxed().reduce(0, getSum(test, index)) / 9;
    }

    private static Function<Integer, List<Integer>> collectAverages(Integer[][] test, Integer width) {
        return j -> IntStream.range(0, width).boxed().map(getAverage(test, j)).collect(Collectors.toList());
    }

    private static List<List<Integer>> blurImage(Integer[][] image, Integer width, Integer height) {
        return IntStream.range(0, height).boxed()
                .map(collectAverages(image, width))
                .collect(Collectors.toList());
    }

    private static Integer[][] convert2dListTo2dArray(List<List<Integer>> lists) {
        Integer[][] array = new Integer[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> row = lists.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }

        return array;
    }

    private void doWithStreams(Integer[][] image) {
        System.out.println("Picture to blur");
        PrintUtil.print2dArray(image);

        int width = image[0].length-2;
        int height = image.length-2;

        List<List<Integer>> result = blurImage(image, width, height);

        convert2dListTo2dArray(result);

        PrintUtil.print2dList(result);
    }

    private void doWithForLoops(Integer[][] test) {

        System.out.println("Picture to blur");
        PrintUtil.print2dArray(test);

        int height = test.length-2;
        int width = test[0].length-2;

        Integer[][] ints = new Integer[height][width];

        for(int j = 0; j < height; j++) {
            int sum = 0;

            for(int z = 0; z < width; z++) {
                for (int i = z; i < 3+z; i++) {
                    sum += test[j][i];
                    sum += test[j+1][i];
                    sum += test[j+2][i];
                }

                int average = sum / 9;

                ints[j][z] = average;

                sum = 0;
            }
        }

        System.out.println("Blur");
        PrintUtil.print2dArray(ints);
        System.out.println();
    }

    @Override
    public void run() {
//        doWithForLoops(TEST_1);
//        doWithForLoops(TEST_2);
//        doWithForLoops(TEST_3);

        doWithStreams(TEST_1);
        doWithStreams(TEST_2);
        doWithStreams(TEST_3);
    }
}
