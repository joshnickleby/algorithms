package nickleby.algorithms.domain.common;

public class Tautologist {

    /**
     * Logic based on the following truth table:
     *
     *    p   q   r
     *    T   T   T
     *    T   F   F
     *    F   T   T
     *    F   F   T
     *
     *  State in normally, if the first boolean is true then check the second one.
     * @param p
     * @param q
     * @return
     */
    public boolean infer(boolean p, boolean q) {
        return !p || q;
    }
}
