package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_18248 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo
        // ???
    }

    static {
        try {
            new baek_18248().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
