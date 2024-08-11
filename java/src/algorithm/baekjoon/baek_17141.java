package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.*;

public class baek_17141 extends Solution {
    static int N;
    static int M;
    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {

            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < N; j++)  {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // algo
        // find 2
        List<Point> viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    viruses.add(new Point(i, j));
                }
            }
        }

        int result = 999999999;
        for (int i = 0; i < (1 << viruses.size()); i++) {

            List<Integer> idxs = new ArrayList<>();
            for (int j = 0; j < viruses.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    idxs.add(j);
                }
            }

            if (idxs.size() == M) {
                Point[] points = new Point[M];

                for (int j = 0; j < M; j++) {
                    points[j] = viruses.get(idxs.get(j));
                }

                int tmp = bfs(points, map);
                if (tmp != -1 && result > tmp) {
                    result = tmp;
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(Point[] points, int[][] map) {
        // 상하좌우
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][N];

        for (Point p : points) {
            queue.add(p);
            visited[p.r][p.c] = 1;
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (visited[nr][nc] > 0)
                    continue;
                if (map[nr][nc] == 1) {
                    visited[nr][nc] = -1;
                    continue;
                }

                queue.add(new Point(nr, nc));
                visited[nr][nc] = visited[p.r][p.c] + 1;

                if (result <= visited[nr][nc]) {
                    result = visited[nr][nc];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    return -1;
                }
            }
        }

        return result - 1;
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
