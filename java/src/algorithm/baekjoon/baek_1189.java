package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_1189 extends Solution {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int result = 0;

    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String temp = read.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        // algo
        // 한수는 캠프를 마치고 집에 돌아가려 한다. 한수는 현재 왼쪽 아래점에 있고 집은 오른쪽 위에 있다.
        // 그리고 한수는 집에 돌아가는 방법이 다양하다. 단, 한수는 똑똑하여 한번 지나친 곳을 다시 방문하지는 않는다.

        // dfs
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1 && cnt == K) {
            result++;
            return ;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            if (nr < 0 || R <= nr || nc < 0 || C <= nc) {
                continue;
            }
            if (map[nr][nc] == 'T') {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }

            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1);
            visited[nr][nc] = false;
        }
    }
}
