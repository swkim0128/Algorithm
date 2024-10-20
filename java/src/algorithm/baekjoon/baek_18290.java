package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_18290 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer tokenizer = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[N][M];
        for (int n = 0; n < N; n++) {

            tokenizer = new StringTokenizer(read.readLine());
            for (int m = 0; m < M; m++) {
                arr[n][m] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // algo
        // 무작위로 K개를 뽑아 조건을 만족하는지 확인
        // K개의 합이 최대값
        // k1, k2, k3, k4 ...
        List<Point> kList = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            int maxN = 0;
            int i = 0, j = 0;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (visited[n][m]) continue;

                    if (maxN < arr[n][m]) {
                        maxN = arr[n][m];
                        i = n;
                        j = m;
                    }
                }
            }

            kList.add(new Point(i, j));
            visited[i][j] = true;
        }

        // output
    }

    public int bfs(int n, int m, int N, int M, int[][] arr) {
        int[] dy = {-1, 1, 1, -1};
        int[] dx = {1, 1, -1, -1};

        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < 0 || N <= ny || nx < 0 || M <= nx) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new Point(ny, nx));
            }
        }
        return 0;
    }

    class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static {
        try {
            new baek_18290().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
