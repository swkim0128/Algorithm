package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1986 extends Solution {
    static int N, M;
    static int[][] arr;

    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][M];

        token = new StringTokenizer(read.readLine());
        int Q = Integer.parseInt(token.nextToken());
        for (int i = 0; i < Q; i++) {
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;

            arr[r][c] = 3;
        }

        token = new StringTokenizer(read.readLine());
        int K = Integer.parseInt(token.nextToken());
        for (int i = 0; i < K; i++) {
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;

            arr[r][c] = 2;
        }

        token = new StringTokenizer(read.readLine());
        int P = Integer.parseInt(token.nextToken());
        for (int i = 0; i < P; i++) {
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;

            arr[r][c] = 1;
        }

        // algo
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    knight(i, j);
                }
                else if (arr[i][j] == 3) {
                    queen(i, j, -1);
                }
            }
        }

        // output
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    sum++;
            }
        }

        System.out.println(sum);
    }

    static void knight(int r, int c) {
        // 중심으로부터 상2, 우2, 하2, 좌2
        int[] dr = {2, 2, 1, -1, -2, -2, -1, 1};
        int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                continue;
            if (arr[nr][nc] != 0)
                continue;

            arr[nr][nc] = -1;
        }
    }

    static void queen(int r, int c, int d) {
        // 북, 북동, 동, 남동, 남, 남서, 서, 북서
        int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        if (d == -1) {
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                    continue;
                }
                if (arr[nr][nc] == 3 || arr[nr][nc] == 2 || arr[nr][nc] == 1) {
                    continue;
                }

                queen(nr, nc, i);
            }
        }
        else {
            arr[r][c] = -1;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                return;
            }
            if (arr[nr][nc] == 3 || arr[nr][nc] == 2 || arr[nr][nc] == 1) {
                return;
            }
            queen(nr, nc, d);
        }
    }
}

