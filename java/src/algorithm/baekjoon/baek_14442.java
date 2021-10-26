package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14442 extends Solution {
    int N, M, K;
    int[][] map;

    int answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] ch = read.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    list.add(new Point(i, j));
            }
        }

        System.out.println(answer);
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int bfs() {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][M];

        queue.offer(new Point(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int r = p.r, c = p.c;

            if (r == N - 1 && c == M - 1)
                break;

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (visited[nr][nc] != 0)
                    continue;
                if (map[nr][nc] == 1)
                    continue;

                visited[nr][nc] = visited[r][c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }

        return visited[N - 1][M - 1];
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
