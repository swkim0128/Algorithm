package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class baek_11559 extends Solution {
    final int MAP_SIZE = 12;
    char[][] map;

    @Override
    public void solution() throws IOException {
        map = new char[MAP_SIZE][MAP_SIZE / 2];

        for (int i = 0; i < MAP_SIZE; i++) {
            map[i] = read.readLine().toCharArray();
        }

        while (true) {
//            Point p = findMap();
//            bfs(p.r, p.c, map[p.r][p.c]);
        }

    }

    public boolean findMap() {
        boolean[][] mapVisited = new boolean[MAP_SIZE][MAP_SIZE / 2];

        for (int j = 0; j < MAP_SIZE / 2; j++) {
            for (int i = MAP_SIZE - 1; i >= 0; i--) {
                if (mapVisited[i][j])
                    continue;
                if (map[i][j] != '*')
                    if (bfs(i, j, map[i][j]))
                        return true;
            }
        }

        return false;
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public boolean bfs(int row, int col, char ch) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[MAP_SIZE][MAP_SIZE / 2];

        queue.offer(new Point(row, col));
        visited[row][col] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int r = p.r, c = p.c;
            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || MAP_SIZE <= nr || nc < 0 || MAP_SIZE / 2 <= nc)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] != ch)
                    continue;

                cnt++;
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc));
            }
        }

        boolean result = false;
        if (cnt >= 4) {
            for (int j = 0; j < MAP_SIZE / 2; j++) {
                for (int i =  0; i < MAP_SIZE ; i++) {
                    if (visited[MAP_SIZE - 1 - i][j])
                        map[MAP_SIZE - 1 - i][j] = '*';
                    else {
                        moveMap(i, j);
                    }
                }
            }

            result = true;
        }

        return result;
    }

    public void moveMap(int r, int c) {
        for (int i = 0; i < MAP_SIZE - r; i++) {
            map[MAP_SIZE - 1 - i][c] = map[MAP_SIZE - 1 - r - i][c];
        }
        for (int i = 0; i < r + 1; i++) {
            map[i][c] = '*';
        }
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
