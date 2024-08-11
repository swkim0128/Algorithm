package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_20152 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        // 강산 좌표
        int H = Integer.parseInt(token.nextToken());
        // PC방 좌표
        int N = Integer.parseInt(token.nextToken());
        int M = 30;


        // algo
        // (x, y)에서 y > x 인 곳은 침수
        int result = bfs(H, N, M);

        // output
        System.out.println(result);
    }

    public int bfs(int H, int N, int M) {
        // 상하좌우
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        Stack<Point> stack = new Stack<>();
        boolean[][] visited = new boolean[M][M];

        // push
        stack.add(new Point(H, H));
        visited[H][H] = true;

        int result = 0;
        while (!stack.isEmpty()) {
            // queue pop
            Point p = stack.pop();
//            visited[p.y][p.x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || 30 <= ny || nx < 0 || 30 <= nx) continue;
                if (ny > nx) continue;
                if (visited[ny][nx]) continue;
                if (ny == N && nx == N) {
                    result++;
                    continue;
                }

                // queue push
                stack.add(new Point(ny, nx));
                visited[ny][nx] = true;
            }
        }

        return result;
    }

    private class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
