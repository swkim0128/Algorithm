package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15566 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] favor = new int[N][4];
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(read.readLine());
            favor[n][0] = Integer.parseInt(token.nextToken());
            favor[n][1] = Integer.parseInt(token.nextToken());
            favor[n][2] = Integer.parseInt(token.nextToken());
            favor[n][3] = Integer.parseInt(token.nextToken());
        }

        int[][] flower = new int[N][2];
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(read.readLine());
            flower[n][0] = Integer.parseInt(token.nextToken());
            flower[n][1] = Integer.parseInt(token.nextToken());
        }

        int[][] talk = new int[M][3];
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(read.readLine());
            talk[m][0] = Integer.parseInt(token.nextToken());
            talk[m][1] = Integer.parseInt(token.nextToken());
            talk[m][2] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 1. 백트레킹
        // 배열 조합

        // 조합 배열에 따른 그래프 탐색 선호도 여부 검사

        // output

    }
    static {
        try {
            new baek_15566().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
