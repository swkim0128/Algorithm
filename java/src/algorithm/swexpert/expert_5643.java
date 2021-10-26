package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class expert_5643 extends Solution {
    @Override
    public void solution() throws IOException {
        final int INF = 999_999_999;
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N, M;
            N = Integer.parseInt(read.readLine());
            M = Integer.parseInt(read.readLine());

            int[][] arr = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {

                    arr[i][j] = INF;
                }
            }
//            ArrayList<Integer>[] list = new ArrayList[N];
//            for (int i = 0; i < N; i++) {
//                list[i] = new ArrayList<>();
//            }

            for (int i = 0; i < M; i++) {
                int a, b;

                StringTokenizer token = new StringTokenizer(read.readLine(), " ");
                a = Integer.parseInt(token.nextToken());
                b = Integer.parseInt(token.nextToken());

                arr[a][b] = 1;
//                list[a].add(b);
            }

            for (int k = 1; k < N + 1; k++) {
                for (int i = 1; i < N + 1; i++) {
                    if (k == i)
                        continue;
                    for (int j = 1; j < N + 1; j++) {
                        if (k == j || i == j)
                            continue;
                        arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i < N + 1; i++) {
                boolean[] isNum = new boolean[N + 1];
                for (int j = 1; j < N + 1; j++) {
                    if (i == j)
                        continue;
                    if (arr[j][i] != INF) {
                        isNum[j] = true;
                    }
                    if (arr[i][j] != INF) {
                        isNum[j] = true;
                    }
                }

                boolean isLine = true;
                for (int j = 1; j < N + 1; j++) {
                    if (i == j)
                        continue;
                    if (!isNum[j]) {
                        isLine = false;
                        break;
                    }
                }

                if (isLine) {
                    answer++;
                }
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}
