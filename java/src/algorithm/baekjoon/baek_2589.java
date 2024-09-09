package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2589 extends Solution {
    static int N, M;
    static char[][] arr;

    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String tmp = read.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        // algo
        // L : land, W : sea
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    int tmp = bfs(i, j);

                    if (result <= tmp) {
                        result = tmp;
                    }
                }
            }
        }

        // output
        System.out.println(result - 1);
    }

    static int bfs(int r, int c) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][M];

        queue.add(new Point(r, c));
        visited[r][c] = 1;

        int result = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                if (arr[nr][nc] == 'W') continue;
                if (visited[nr][nc] != 0) continue;

                queue.add(new Point(nr, nc));
                visited[nr][nc] = visited[p.r][p.c] + 1;

                if (result <= visited[nr][nc]) {
                    result = visited[nr][nc];
                }
            }
        }

        return result;
    }

    private static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
