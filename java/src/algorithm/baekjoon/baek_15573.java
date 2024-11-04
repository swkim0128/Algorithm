package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_15573 extends Main {
    static int N, M, K;
    static int[][] S;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        S = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < M; j++) {
                S[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo

    }

    static Integer bfs(int r, int c, int d) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int k = 0;

        queue.add(new Point(r, c));
        visited[r][c] = true;
        k++;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                if (visited[nr][nc]) continue;
                if (S[nr][nc] > d) continue;

                queue.add(new Point(nr, nc));
                visited[nr][nc] = true;
                k++;
            }
        }

        return 0;
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static {
         try {
             new baek_15573().run();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
}
