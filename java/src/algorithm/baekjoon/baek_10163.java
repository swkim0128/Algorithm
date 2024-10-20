package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_10163 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

        final int ARR_SIZE = 1001;
        int[][] arr = new int[ARR_SIZE][ARR_SIZE];

        StringTokenizer token;
        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(read.readLine(), " ");

            int startC = Integer.parseInt(token.nextToken());
            int startR = Integer.parseInt(token.nextToken());
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());

            for (int i = startR; i < startR + height; i++) {
                for (int j = startC; j < startC + width; j++) {
                    arr[i][j] = n;
                }
            }
        }

        int[] answer = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            for (int i = 0; i < ARR_SIZE; i++) {
                for (int j = 0; j < ARR_SIZE; j++) {
                    if (arr[i][j] == n) {
                        answer[n]++;
                    }
                }
            }
        }

        for (int n = 1; n < N + 1; n++) {
            System.out.println(answer[n]);
        }
    }
    static {
        try {
            new baek_10163().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
