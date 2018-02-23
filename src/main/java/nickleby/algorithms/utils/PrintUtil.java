package nickleby.algorithms.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintUtil {

    public static void printArray(Object[] array) {
        System.out.println("[" + Stream.of(array).map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

    public static void print2dArray(Object[][] arrays) {
        Stream.of(arrays).forEach(PrintUtil::printArray);
    }

    public static void print2dArray(List<? extends Object[]> arrays) {
        arrays.forEach(PrintUtil::printArray);
    }

    public static void printList(List<? extends Object> list) {
        System.out.println("[" + list.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
    }

    public static void print2dList(List<List<Integer>> lists) {
        lists.forEach(PrintUtil::printList);
    }

    public static void printMap(Map<? extends Object, ? extends Object> map) {
        map.forEach((key, value) -> System.out.println("{" + key.toString() + " : " + value.toString() + "}"));
    }
}
