package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1263 extends Solution {
    @Override
    public void solution() throws IOException {
        final int INF = 999_999_999;
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            int N = Integer.parseInt(token.nextToken());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    if (arr[i][j] == 0)
                        arr[i][j] = INF;
                }
            }

            int answer = fluid(arr);
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    public int fluid(int[][] arr) {
        int N = arr.length;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k)
                    continue;
                for (int j = 0; j < N; j++) {
                    if (j == k || i == j)
                        continue;
                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        int[] cc = new int[N];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                cc[i] += arr[i][j];
            }

            if (min > cc[i])
                min = cc[i];
        }

        return min;
    }
}
