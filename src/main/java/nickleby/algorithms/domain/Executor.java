package nickleby.algorithms.domain;

import lombok.NoArgsConstructor;
import nickleby.algorithms.domain.lambdas.LambdaVariable;

@NoArgsConstructor
public class Executor {

    public static BoxBlur boxBlur = new BoxBlur();
    public static LambdaVariable lambdaVariable = new LambdaVariable();

    public static void run() {
        boxBlur.run();
    }
}
