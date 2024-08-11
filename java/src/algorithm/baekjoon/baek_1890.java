package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_1890 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // algo
        long result = bfs(arr, N);

        // output
        System.out.println(result);
    }

    long bfs(int[][] arr, int N) {
        // (y, x) r, d
        int[][] direct = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[N][N];

        Stack<Point> stack = new Stack<>();
        stack.add(new Point(0, 0));

        long result = 0;
        while (!stack.isEmpty()) {
            Point point = stack.pop();
            visited[point.y][point.x] = true;

            for (int i = 0; i < 2; i++) {
                int y = direct[i][0];
                int x = direct[i][1];

                int nextY = point.y + y * arr[point.y][point.x];
                int nextX = point.x + x * arr[point.y][point.x];

                if (N <= nextY || N <= nextX) continue;
                if (arr[nextY][nextX] == 0) continue;
                if (visited[nextY][nextX]) continue;
                if (nextY == N - 1 && nextX == N - 1) {
                    result++;
                    visited[point.y][point.x] = false;
                    continue;
                }

                stack.add(new Point(nextY, nextX));
            }
        }

        return result;
    }

    private class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
