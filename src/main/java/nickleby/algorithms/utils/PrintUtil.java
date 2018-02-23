package nickleby.algorithms.utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintUtil {

    public static void printArray(Object[] array) {
        System.out.println("[" + Stream.of(array).map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

    public static void printMultiDimensionArray(Object[][] arrays) {
        Stream.of(arrays).forEach(PrintUtil::printArray);
    }
}
