package nickleby.algorithms.domain.wizeline;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ApiRoutes {

    /**
     * You are given a list of API calls in the format /project/subproject/method. You need to calculate and print the number of calls to each node of the API endpoint as a tree.
     * <p>
     * In this tree, projects, subprojects, and methods should be sorted in the same order as they were given in the input data. The output tree should consist of several strings. All subprojects fall under their parent project, and all methods fall under the subproject in which they are included. The string that represents a project starts with --, while subprojects start with ---- and methods start with ------. After the project, subproject, or method name, put the number of requests to this module in parentheses. Take a look at the example for a guide of what this tree should look like.
     * <p>
     * Example
     * <p>
     * For
     * <p>
     * calls = [
     * "/project1/subproject1/method1",
     * "/project2/subproject1/method1",
     * "/project1/subproject1/method1",
     * "/project1/subproject2/method1",
     * "/project1/subproject1/method2",
     * "/project1/subproject2/method1",
     * "/project2/subproject1/method1",
     * "/project1/subproject2/method1"
     * ]
     * the output should be
     * <p>
     * countAPI(calls) = [
     * "--project1 (6)",
     * "----subproject1 (3)",
     * "------method1 (2)",
     * "------method2 (1)",
     * "----subproject2 (3)",
     * "------method1 (3)",
     * "--project2 (2)",
     * "----subproject1 (2)",
     * "------method1 (2)"
     * ]
     */

    static String[] calls = {
            "/project1/subproject1/method1",
            "/project2/subproject1/method1",
            "/project1/subproject1/method1",
            "/project1/subproject2/method1",
            "/project1/subproject1/method2",
            "/project1/subproject2/method1",
            "/project2/subproject1/method1",
            "/project1/subproject2/method1"
    };

    static String[] countAPI = {
            "--project1 (6)",
            "----subproject1 (3)",
            "------method1 (2)",
            "------method2 (1)",
            "----subproject2 (3)",
            "------method1 (3)",
            "--project2 (2)",
            "----subproject1 (2)",
            "------method1 (2)"
    };

    private static String[] countAPI(String[] calls) {
        Map<String, Integer> count = new LinkedHashMap<>();

        Stream.of(calls).forEach(call -> count.put(call, count.containsKey(call) ? count.get(call) : 1));

        count.forEach((k,v) -> System.out.println(k + " " + v));

        return new String[]{};
    }

    public static void main(String[] args) {
        String[] count = countAPI(calls);

        Stream.of(count).forEach(c -> System.out.println(c));
    }

}