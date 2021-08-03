package algorithm;

import java.io.IOException;

public class Excute {
    public static void excute(SolutionImpl s) {
        try {
            SolutionImpl solution = s;
            solution.solution();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}
