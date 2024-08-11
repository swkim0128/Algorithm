package algorithm.programmers;

import algorithm.Solution;

import java.io.IOException;
import java.util.*;

public class test extends Solution {
    String[] replies = {"AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB"};
    int n = 3; int k = 2;
    int[] answer = new int[replies.length];

    @Override
    public void solution() throws IOException {
        for (int r = 0; r < replies.length; r++) {
            int cnt = 0;
            while (n + cnt < replies[r].length()) {
                if (find(r, n + cnt)) {
                    break;
                }
                cnt++;
            }
        }

        System.out.println(Arrays.toString(answer));
    }

    public boolean find(int r, int cnt) {
        int N = cnt;

        option : for (int i = 0; i < replies[r].length(); i++) {
            if (i + N >= replies[r].length() + 1)
                break;

            String compareStr = replies[r].substring(i, i + N);
            int startIdx = i + N;
            int endIdx = startIdx + N;
            boolean isError = true;

            for (int j = 0; j < k - 1; j++) {
                if (endIdx >= replies[r].length() + 1) {
                    isError = false;
                    break option;
                }

                String temp = replies[r].substring(startIdx, endIdx);
                startIdx += N; endIdx += N;

                if (!temp.equals(compareStr)) {
                    isError = false;
                }
            }

            if (isError) {
                answer[r] = 0;
                return true;
            }
            else {
                answer[r] = 1;
            }
        }

        return false;
    }
}
