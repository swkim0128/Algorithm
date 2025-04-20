package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_20208 extends Main {
    static int N, M, H;
    static int[][] arr;
    static int maxResult  = 0;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        arr = new int[N][N];

        int sr = 0, sc = 0;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());

                if (arr[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        dfs(sr, sc, M, 0);

        System.out.println(maxResult);
    }

    void dfs(int r, int c, int h, int depth) {
        if (depth == 11) {
            return;
        }

        ArrayList<Point> list = bfs(r, c, h);

        for (Point tmpP : list) {
            if (arr[tmpP.r][tmpP.c] == 1) {
                if (maxResult < depth) {
                    maxResult = depth;
                }
                continue;
            }

            arr[tmpP.r][tmpP.c] = 0;
            dfs(tmpP.r, tmpP.c, tmpP.h, depth + 1);
            arr[tmpP.r][tmpP.c] = 2;
        }
    }

    ArrayList<Point> bfs(int r, int c, int h) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new Point(r, c, h));
        visited[r][c] = true;

        ArrayList<Point> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (p.h == 0) {
                    continue;
                }

                if (arr[nr][nc] == 1) {
                    result.add(new Point(nr, nc, p.h - 1));
                } else if (arr[nr][nc] == 2) {
                    result.add(new Point(nr, nc, p.h - 1 + H));
                }

                queue.add(new Point(nr, nc, p.h - 1));
                visited[nr][nc] = true;
            }
        }

        return result;
    }

    class Point {
        int r, c;
        int h;

        Point(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    static {
        try {
            new baek_20208().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
