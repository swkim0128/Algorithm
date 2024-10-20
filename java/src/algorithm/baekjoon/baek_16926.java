package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16926 extends Main {
    int[][] map;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, M, R;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            reculsive(0, N, 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reculsive(int sR, int eR, int sC, int eC) {
        int temp = map[sR][sC];

        for (int i = sC; i < eC - 1; i++) {
            map[sR][i] = map[sR][i + 1];
        }
        for (int i = sR; i < eR - 1; i++) {
            map[i][eC - 1] = map[i + 1][eC - 1];
        }
        for (int i = eC - 1; i > sC; i--) {
            map[eR - 1][i] = map[eR - 1][i - 1];
        }
        for (int i = eR - 1; i > sR; i--) {
            map[i][sC] = map[i - 1][sC];
        }
        map[sR + 1][sC] = temp;

        if (eR - sR == 2 || eC - sC == 2) {
            return;
        }

        reculsive(sR + 1, eR - 1, sC + 1, eC - 1);
    }
    static {
        try {
            new baek_16926().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
