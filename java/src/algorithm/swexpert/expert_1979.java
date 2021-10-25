package algorithm.swexpert;

import algorithm.Solution;
import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1979 extends Solution {
    int N, K;
    int[][] arr;

    int answer;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());

            arr = new int[N][N];
            visited0 = new boolean[N][N];
            visited1 = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) {
                        if (!visited0[i][j])
                            dfs(i, j, 0, 1);
                        if (!visited1[i][j])
                            dfs(i, j, 1, 1);
                    }
                }
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    int[] dr = {0, 1};
    int[] dc = {1, 0};
    boolean[][] visited0;
    boolean[][] visited1;

    public void dfs(int r, int c, int d, int amount) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (nr < 0 || N <= nr || N <= nc) {
            if (K == amount)
                answer++;
            return;
        }
        if (arr[nr][nc] == 0) {
            if (K == amount)
                answer++;
            return;
        }

        if (d == 0) {
            visited0[r][c] = true;
        }
        else if (d == 1) {
            visited1[r][c] = true;
        }

        dfs(nr, nc, d, amount + 1);
    }
}
