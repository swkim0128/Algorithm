package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_18430 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N, M;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo
        int result = 0;

        // 탐색
        // 특정 도형 방향이 정해지면 거기에 맞는 도형 탐색
        // 최대값 구하기

        // output
        System.out.println(result);
    }

    class bumerang {
        // center
        int cr;
        int cl;
        // 세로
        int hr;
        int hl;
        // 가로
        int vr;
        int vl;
    }
}
