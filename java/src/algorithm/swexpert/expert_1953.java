package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class expert_1953 extends Solution {
    int N, M, R, C, L;
    int[][] map;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());
            L = Integer.parseInt(token.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int answer = bfs();
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new Point(R, C, 1));
        visited[R][C] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.depth == L)
                continue;

            int r = p.r, c = p.c;
            int nr, nc;

            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == 0)
                    continue;
                if (!isGo(map[r][c], i))
                    continue;
                if (!isConnected(map[nr][nc], i))
                    continue;

                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, p.depth + 1));
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    public boolean isGo(int direct, int d) {
        boolean result = false;
        switch (direct) {
            case 1:
                result = true;
                break;
            case 2:
                result = (d == 0 || d == 2) ? true : false;
                break;
            case 3:
                result = (d == 1 || d == 3) ? true : false;
                break;
            case 4:
                result = (d == 0 || d == 1) ? true : false;
                break;
            case 5:
                result = (d == 1 || d == 2) ? true : false;
                break;
            case 6:
                result = (d == 2 || d == 3) ? true : false;
                break;
            case 7:
                result = (d == 0 || d == 3) ? true : false;
                break;
        }

        return result;
    }

    public boolean isConnected(int direct, int d) {
        boolean result = false;
        switch (direct) {
            case 1:
                result = true;
                break;
            case 2:
                result = (d == 0 || d == 2) ? true : false;
                break;
            case 3:
                result = (d == 1 || d == 3) ? true : false;
                break;
            case 4:
                result = (d == 2 || d == 3) ? true : false;
                break;
            case 5:
                result = (d == 0 || d == 3) ? true : false;
                break;
            case 6:
                result = (d == 0 || d == 1) ? true : false;
                break;
            case 7:
                result = (d == 1 || d == 2) ? true : false;
                break;
        }

        return result;
    }

    class Point {
        int r, c;
        int depth;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Point(int r, int c, int d) {
            this(r, c);
            this.depth = d;
        }
    }
}
