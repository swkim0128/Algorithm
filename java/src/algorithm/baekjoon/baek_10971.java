package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10971 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo


        // output
    }
    static {
        try {
            new baek_10971().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
