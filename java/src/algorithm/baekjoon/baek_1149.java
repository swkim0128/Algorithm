package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1149 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        int[][] house = new int[N + 1][3];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            house[i][0] = Integer.parseInt(token.nextToken());
            house[i][1] = Integer.parseInt(token.nextToken());
            house[i][2] = Integer.parseInt(token.nextToken());
        }

        int[][] dp = new int[N + 1][3];
        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0: {
                        dp[i][0] = Math.min(house[i][0] + dp[i - 1][1], house[i][0] + dp[i - 1][2]);
                    }
                        break;
                    case 1: {
                        dp[i][1] = Math.min(house[i][1] + dp[i - 1][0], house[i][1] + dp[i - 1][2]);
                    }
                        break;
                    case 2: {
                        dp[i][2] = Math.min(house[i][2] + dp[i - 1][0], house[i][2] + dp[i - 1][1]);
                    }
                        break;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (result > dp[N][i])
                result = dp[N][i];
        }

        System.out.println(result);
    }
}
