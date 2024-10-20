package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_17406 extends Main {
    int N, M;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int K;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        K = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int[] r = new int[K];
        int[] c = new int[K];
        int[] s = new int[K];

        for (int i = 0; i < K; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            r[i] = Integer.parseInt(token.nextToken());
            c[i] = Integer.parseInt(token.nextToken());
            s[i] = Integer.parseInt(token.nextToken());
        }

    }

    public int[][] rotate(int[][] arr, int r, int c, int s) {
        int[][] result = new int[N][M];



        return result;
    }
    static {
        try {
            new baek_17406().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
