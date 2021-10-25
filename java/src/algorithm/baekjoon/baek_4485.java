package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_4485 extends Solution {
    int N;
    int[][] map;

    @Override
    public void solution() throws IOException {

        int cnt = 1;
        while (true) {
            N = Integer.parseInt(read.readLine());
            if (N == 0)
                break;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int answer = bfs();
            System.out.println("Problem " + cnt + ": " + answer);
            cnt++;
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int bfs() {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        queue.offer(new Point(0, 0));
        visited[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int r = p.r, c = p.c;
            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;

                int nVisi = visited[r][c] + map[nr][nc];

                if (visited[nr][nc] != -1 && visited[nr][nc] > nVisi) {
                    visited[nr][nc] = nVisi;
                    queue.offer(new Point(nr, nc));
                    continue;
                }
                else if (visited[nr][nc] != -1 && visited[nr][nc] < nVisi) {
                    continue;
                }
                else if (visited[nr][nc] == -1) {
                    visited[nr][nc] = nVisi;
                    queue.offer(new Point(nr, nc));
                }
            }
        }

        return visited[N - 1][N - 1];
    }

    class Point {

        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
