package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576 extends Main {
    int N, M;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int answer = bfs(map);
        boolean isComplete = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    isComplete = false;
                }
            }
        }

        if (isComplete) {
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int bfs(int[][] map) {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (result < map[p.r][p.c]) {
                result = map[p.r][p.c];
            }

            int r = p.r, c = p.c;
            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (map[nr][nc] != 0 || map[nr][nc] == -1)
                    continue;

                map[nr][nc] = map[r][c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }

        return result - 1;
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_7576().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
