package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class expert_1868 extends Solution {
    int N;
    char[][] map;
    ArrayList<Point> list = new ArrayList<>();

    int answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {

            N = Integer.parseInt(read.readLine());

            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = read.readLine().toCharArray();
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }



    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(p);

        visited[p.r][p.c] = true;

        while (!queue.isEmpty()) {
            Point po = queue.poll();

            if (findMind(po))
                continue;

            int r = po.r, c = po.c;
            int nr, nc;
            for (int i = 0; i < 8; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == '*')
                    continue;

                queue.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }
    }

    public boolean findMind(Point p) {
        int r = p.r, c = p.c;
        int nr, nc;
        int cnt = 0;
        boolean result = false;
        for (int i = 0; i < 8; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

            if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                continue;

            if (map[nr][nc] == '*') {
                cnt++;
                result = true;
            }
        }

        map[r][c] = (char) (cnt + '0');
        return result;
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
