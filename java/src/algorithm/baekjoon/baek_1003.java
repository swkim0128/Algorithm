package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_1003 extends Solution {

    @Override
    public void solution() throws IOException {
        // input
        int T = Integer.parseInt(read.readLine());

        for (int t = 0; t < T; t++) {
            // input
            int N = Integer.parseInt(read.readLine());

            // algo
            int[][] dp = fibo(N);

            // output
            System.out.printf("%d %d\n", dp[N][0], dp[N][1]);
        }
    }

    int[][] fibo(int n) {
        int[][] dp = new int [n + 1][2];

        if (n == 0) {
            dp[0][0]++;
            return dp;
        }
        else if (n == 1) {
            dp[1][1]++;
            return dp;
        }
        else if (n == 2) {
            dp[2][0]++;
            dp[2][1]++;
            return dp;
        }

        dp[0][0]++;
        dp[1][1]++;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        return dp;
    }
}
