package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_21940 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, M;
        int[][] arr;

        int K;
        int[] kArr;

        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int t = Integer.parseInt(token.nextToken());

            arr[a][b] = t;
        }

        K = Integer.parseInt(read.readLine());

        kArr = new int[K];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < K; i++) {
            kArr[i] = Integer.parseInt(token.nextToken());
        }
    }
    static {
        try {
            new baek_21940().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
