package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_2001 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int max = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (i + M <= N && j + M <= N) {
                        for (int r = i; r < i + M; r++) {
                            for (int c = j; c < j + M; c++) {
                                sum += map[r][c];
                            }
                        }

                        if (max < sum) {
                            max = sum;
                        }
                        sum = 0;
                    }
                    else {
                        continue;
                    }
                }
            }

            answer[t] = max;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
