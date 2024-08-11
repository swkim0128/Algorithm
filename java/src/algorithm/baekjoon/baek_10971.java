package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_10971 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo


        // output
    }
}
