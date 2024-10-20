package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1553 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = 8;
        int M = 7;

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = read.readLine();
            for (int j = 0; j < M; j++) {

                int n = Integer.parseInt(String.valueOf(temp.charAt(j)));
                arr[i][j] = n;
            }
        }

        // algo

        // 주사위 조합 visited 여부 확인 0부터 6까지 조합 경우의 수
        // 00 01 02 03 04 05 06
        // 11 12 13 14 15 16
        // 22 23 24 25 26
        // ..

        // 8 * 7 격자를 여러개 조합한 판이 부합하는지 체크
        // dfs 탐색점 중심으로 오른쪽, 아래 하나 체크
        // 마지막 점이 조건에 부합하지 못하면
    }
    static {
        try {
            new baek_1553().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
