package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_4963 extends Main {
    int w, h;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token;

        while (true) {
            token = new StringTokenizer(read.readLine(), " ");

            w = Integer.parseInt(token.nextToken());
            h = Integer.parseInt(token.nextToken());

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];

            for (int i = 0; i < h; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            boolean[][] visted = new boolean[h][w];
            int answer = bfs(map, visted);
            System.out.println(answer);
        }
    }

    public int bfs(int[][] map, boolean[][] visited) {
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        Queue<Data> queue = new LinkedList<>();

        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0) continue;
                if (visited[i][j]) continue;

                queue.offer(new Data(i, j));
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    Data d = queue.poll();

                    int nr, nc;

                    for (int n = 0; n < 8; n++) {
                        nr = d.r + dr[n];
                        nc = d.c + dc[n];

                        if (nr < 0 || h <= nr || nc < 0 || w <= nc) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;

                        queue.offer(new Data(nr, nc));
                        visited[nr][nc] = true;
                    }
                }

                result++;
            }
        }

        return result;
    }

    class Data {
        int r, c;

        Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_4963().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
