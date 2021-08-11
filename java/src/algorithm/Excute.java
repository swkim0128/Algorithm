package algorithm;

import java.io.IOException;

public class Excute {
    public static void excute(SolutionImpl s) {
        try {
            s.solution();
        }
        catch (IOException e) {
            e.getStackTrace();
        }
    }
}
