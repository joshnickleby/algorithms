package nickleby.algorithms.domain;

import lombok.NoArgsConstructor;
import nickleby.algorithms.domain.lambdas.LambdaVariable;

@NoArgsConstructor
public class Executor {

    public static LambdaVariable lambdaVariable = new LambdaVariable();
    public static BoxBlur boxBlur = new BoxBlur();
    public static Minesweeper minesweeper = new Minesweeper();

    public static void run() {
        minesweeper.run();
    }
}
