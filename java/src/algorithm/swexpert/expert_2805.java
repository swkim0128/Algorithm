package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;

public class expert_2805 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());
            int[][] farmArr = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                char[] temp = read.readLine().toCharArray();

                for (int j = 0; j < N; j++) {
                    farmArr[i][j] = temp[j] - '0';
                }
            }

            int count = N / 2 + 1;
            int centerY = N / 2;
            int centerX = N / 2;
            int y = 0, x = 0;
            int sum = 0;

            for (int i = 0; i < count; i++) {
                for (int j = 0; j < i + 1; j++) {
                    x = j;
                    y = -x + i;
                    if (!visited[centerY + y][centerX + x]) {
                        sum += farmArr[centerY + y][centerX + x];
                        visited[centerY + y][centerX + x] = true;
                    }

                    y = x - i;
                    if (!visited[centerY + y][centerX + x]) {
                        sum += farmArr[centerY + y][centerX + x];
                        visited[centerY + y][centerX + x] = true;
                    }

                    x = -j;
                    y = -x - i;
                    if (!visited[centerY + y][centerX + x]) {
                        sum += farmArr[centerY + y][centerX + x];
                        visited[centerY + y][centerX + x] = true;
                    }

                    y = x + i;
                    if (!visited[centerY + y][centerX + x]) {
                        sum += farmArr[centerY + y][centerX + x];
                        visited[centerY + y][centerX + x] = true;
                    }
                }
            }

            answer[t] = sum;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
