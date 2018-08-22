package nickleby.algorithms.domain;

public class ForLoopWeirdness {

    public static void main(String[] args) {
        int i = 0;

        for(;;) {
            System.out.println("Hmm " + i);
            i++;
        }
    }
}
