package algorithm.baekjoon;

import algorithm.Solution;
import sun.awt.image.ImageWatched;

import java.io.IOException;
import java.util.*;

public class baek_2636 extends Solution {
    static int N;
    static int M;
    static int[][] arr;

    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

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
        int cnt = 1;
        while (true) {
            bfs(cnt);

            boolean isContinue = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == cnt + 1)
                        isContinue = true;
                }
            }

            if (isContinue) {
                cnt++;
            }
            else {
                break;
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == cnt) {
                    sum++;
                }
            }
        }

        // output
        System.out.println(cnt);
        System.out.println(sum);
    }

    static void bfs(int t) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                if (visited[nr][nc]) continue;
                if (arr[nr][nc] == t) {
                    visited[nr][nc] = true;
                }
                if (arr[nr][nc] != t) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == t) {
                    arr[i][j]++;
                }
            }
        }
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
