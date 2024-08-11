package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class baek_20162 extends Solution {

    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        int[] avg = new int[N];
        for (int i = 0; i < N; i++) {
            avg[i] = Integer.parseInt(read.readLine());
        }

        // algo
        int max = 0;
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            if (tmp < avg[i]) {
                tmp = avg[i];
                max += avg[i];
            }
        }

        // output
        System.out.println(max);
    }
}
