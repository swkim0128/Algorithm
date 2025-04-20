package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2411 extends Main {
    int N, M, A, B;
    int[][] map;
    boolean[][] visited;

    int result = 0;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < A; i++) {
            token = new StringTokenizer(read.readLine());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;

            map[r][c] = 1;
        }

        for (int i = 0; i < B; i++) {
            token = new StringTokenizer(read.readLine());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;

            map[r][c] = 2;
        }

        // 이동 시 오른쪽이나 위쪽으로만 이동 가능
        // -> 오른쪽이나 아래쪽으로 이동
        dfs(0, 0);

        System.out.println(result);
    }

    private void dfs(int r, int c) {
        if (r == N - 1 && c == M - 1) {
            boolean isClear = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        isClear = false;
                        break;
                    }
                }

                if (!isClear) {
                    break;
                }
            }

            if (isClear) {
                result++;
            }

            return;
        }

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                continue;
            }
            if (map[nr][nc] == 2) {
                continue;
            }

            int tmp = map[nr][nc];
            map[nr][nc] = 3;
            dfs(nr, nc);
            map[nr][nc] = tmp;
        }
    }

    static {
        try {
            new baek_2411().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
