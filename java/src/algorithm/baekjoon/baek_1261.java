package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1261 extends Main {
    int M, N;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = read.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        int answer = bfs(map);

        System.out.println(answer);
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int bfs(int[][] map) {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][M];

        queue.offer(new Point(0, 0));
        visited[0][0] = 1;

        Queue<Point> wall = new LinkedList<>();

        while (!queue.isEmpty() || !wall.isEmpty()) {
            Point p;
            if (!queue.isEmpty()) {
                p = queue.poll();
            }
            else {
                while (!wall.isEmpty()) {
                    queue.offer(wall.poll());
                }
                p = queue.poll();
            }

            int r = p.r;
            int c = p.c;

            if (r == N - 1 && c == M - 1) {
                break;
            }

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (visited[nr][nc] != 0)
                    continue;

                if (map[nr][nc] == 0) {
                    visited[nr][nc] = visited[r][c];
                    queue.offer(new Point(nr, nc));
                }
                else if (map[nr][nc] == 1) {
                    visited[nr][nc] = visited[r][c] + 1;
                    wall.offer(new Point(nr, nc));
                }
            }
        }

        return visited[N - 1][M - 1] - 1;
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
            new baek_1261().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
