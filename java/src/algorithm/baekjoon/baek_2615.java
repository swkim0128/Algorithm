package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2615 extends Main {
    final int N = 19;
    int[][] map;
    boolean[][][] visited;

    int answer = 0;
    int answerR = 0, answerC = 0;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        visited = new boolean[4][N][N];

        loop:for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    continue;

                if (find(i, j)) {
                    break loop;
                }
            }
        }

        if (answer == 0) {
            System.out.println(answer);
        }
        else {
            System.out.println(answer);
            System.out.println(answerR + " " + answerC);
        }
    }

    int[] dr = {0, 1, 1, 1};
    int[] dc = {1, 1, 0, -1};

    public boolean find(int row, int col) {
        int doll = map[row][col];

        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int r = row;
            int c = col;
            if (visited[i][r][c])
                continue;
            visited[i][r][c] = true;

            int nr, nc;
            int cnt = 1;
            while (true) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    break;
                if (map[nr][nc] != doll)
                    break;

                visited[i][nr][nc] = true;
                cnt++;

                r = nr;
                c = nc;
            }

            if (cnt == 5) {
                answer = doll;

                if (i != 3) {
                    answerR = row + 1;
                    answerC = col + 1;
                }
                else {
                    answerR = r + 1;
                    answerC = c + 1;
                }

                result = true;
                break;
            }
        }

        return result;
    }
    static {
        try {
            new baek_2615().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
