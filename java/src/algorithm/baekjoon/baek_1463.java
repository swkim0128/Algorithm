package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_1463 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        int[] dp = new int[N + 1];

        if (N == 1) {
            System.out.println(0);
            return;
        }

        if (2 <= N && N < 4) {
            System.out.println(1);
            return;
        }

        dp[1] = 0;
        dp[2] = dp[3] = 1;

        for (int i = 4; i < N + 1; i++) {
            dp[i] = 1 + dp[i - 1];

            if (i % 2 == 0) {
                dp[i] = Math.min(1 + dp[i / 2], dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(1 + dp[i / 3], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
