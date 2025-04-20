package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_27211 extends Main {
    static int N, M;
    static int[][] arr;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs(int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(r, c));
        arr[r][c] = 2;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                nr = (N + nr) % N;
                nc = (M + nc) % M;

                if (arr[nr][nc] == 2 || arr[nr][nc] == 1) {
                    continue;
                }

                queue.add(new Point(nr, nc));
                arr[nr][nc] = 2;
            }
        }
    }

    private static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static {
        try {
            new baek_27211().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
