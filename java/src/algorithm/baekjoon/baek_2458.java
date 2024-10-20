package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2458 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        final int INF = 999_999_999;
        int N, M;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            arr[a][b] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) continue;
                if (arr[i][j] == 0)
                    arr[i][j] = INF;
            }
        }

        fluid(arr);

        int answer = 0;
        for (int k = 1; k < N + 1; k++) {
            boolean isOrder = true;
            for (int i = 1; i < N + 1; i++) {
                if (k == i)
                    continue;
                if (arr[k][i] == INF && arr[i][k] == INF) {
                    isOrder = false;
                }
            }

            if (isOrder)
                answer++;
        }

        System.out.println(answer);
    }

    public void fluid(int[][] arr) {
        int N = arr.length;

        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                if (k == i)
                    continue;
                for (int j = 1; j < N; j++) {
                    if (k == j || i == j)
                        continue;

                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

    }
    static {
        try {
            new baek_2458().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
