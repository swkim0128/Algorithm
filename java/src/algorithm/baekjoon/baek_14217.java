package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14217 extends Main {
    static int N, M;
    static int[][] arr;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int Q;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            arr[r][c] = 1;
            arr[c][r] = 1;
        }

        Q = Integer.parseInt(read.readLine());
        for (int i = 0; i < Q; i++) {
            token = new StringTokenizer(read.readLine());

            int a = Integer.parseInt(token.nextToken());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            int tmp = arr[r][c];

            if (a == 1) {
                arr[r][c] = 1;
                arr[c][r] = 1;
            } else if (a == 2) {
                arr[r][c] = 0;
                arr[c][r] = 0;
            }

            int[] result = new int[N];
            result[0] = 0;
            for (int j = 1; j < N; j++) {
                int cnt = bfs(j);
                result[j] = cnt;
            }

            for (int j = 0; j < N; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static Integer bfs(int start) {
        Queue<Point> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.add(new Point(start, 1));
        visited[start] = true;

        int result = -1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (arr[p.idx][0] == 1) {
                result = p.depth++;
                break;
            }

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                if (p.idx == i) {
                    continue;
                }

                if (arr[p.idx][i] == 1) {
                    queue.add(new Point(i, p.depth + 1));
                    visited[i] = true;
                }
            }
        }

        return result;
    }

    private static class Point {
        int idx, depth;

        Point(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }

    static {
        try {
            new baek_14217().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
