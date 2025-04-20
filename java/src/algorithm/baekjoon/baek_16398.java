package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16398 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N;
        int[][] arr;

        N = Integer.parseInt(read.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo
        boolean[][] visited = new boolean[N][N];

        int result = 0;
        for (int i = 0; i < N; i++) {
            int min = 999999;
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (visited[i][j]) {
                    continue;
                }
                if (min > arr[i][j]) {
                    min = arr[i][j];
                    tmp = j;
                }
            }

            result += min;
            visited[i][tmp] = true;
            visited[tmp][i] = true;
        }

        System.out.println(result);
    }

    static {
        try {
            new baek_16398().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
