package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1463 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

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
    static {
        try {
            new baek_1463().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
