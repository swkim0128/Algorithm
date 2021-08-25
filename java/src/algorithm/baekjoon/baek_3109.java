package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_3109 extends Solution {
    int R, C;
    char[][] map;

    int answer = 0;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R][C];

        String s;
        for (int i = 0; i < R; i++) {
           s = read.readLine();
           map[i] = s.toCharArray();
        }

        runPipe();

        System.out.println(answer);
    }

    boolean isArrived = false;

    public void runPipe() {
        for (int i = 0; i < R; i++) {
            map[i][0] = 'U';
            dfs(i, 0);
            isArrived = false;
        }
    }

    int[] dr = {-1, 0, 1};
    int[] dc = {1, 1, 1};

    public void dfs(int r, int c) {
        if (c == C - 1) {
            answer++;
            return;
        }

        int nr, nc;
        for (int i = 0; i < 3; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

            if (isArrived)
                return;
            if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                continue;
            if (map[nr][nc] == 'X' || map[nr][nc] == 'U')
                continue;
            if (nc == C - 1) {
                map[nr][nc] = 'U';
                answer++;
                isArrived = true;
                return;
            }
            if (map[nr][nc] == '.') {
                map[nr][nc] = 'U';
                dfs(nr, nc);
            }
        }
    }
}
