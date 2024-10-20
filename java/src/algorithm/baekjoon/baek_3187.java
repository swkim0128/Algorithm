package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_3187 extends Main {
    int R;
    int C;
    boolean[][] visited;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = read.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        // algo
        visited = new boolean[R][C];

        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) continue;
                else {
                    int[] cnt = bfs(i, j, map);
                    sheep += cnt[0];
                    wolf += cnt[1];
                }
            }
        }

        // output
        System.out.printf("%s %s%n", sheep, wolf);
    }

    public int[] bfs(int r, int c, char[][] map) {
        // 상, 하, 좌, 우
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        Queue<Point> queue = new LinkedList<>();

        int sheep = 0;
        int wolf = 0;

        visited[r][c] = true;
        queue.add(new Point(r, c));

        if (map[r][c] == 'v') {
            wolf++;
        }
        else if (map[r][c] == 'k') {
            sheep++;
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (map[nr][nc] == '#') {
                    visited[nr][nc] = true;
                    continue;
                }
                if (visited[nr][nc])
                    continue;

                // 늑대
                if (map[nr][nc] == 'v') {
                    wolf++;
                }
                // 양
                if (map[nr][nc] == 'k') {
                    sheep++;
                }

                visited[nr][nc] = true;
                queue.add(new Point(nr, nc));
            }
        }

        if (sheep > wolf) {
            wolf = 0;
        }
        else {
            sheep = 0;
        }

        return new int[] {sheep, wolf};
    }

    private class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_3187().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
