package algorithm.jungol;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class jungol_1681 extends Solution {
    int N;
    int[][] arr;

    int answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        N = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        dfs(arr, 0, 0, 0);

        System.out.println(answer);
    }

    boolean[] visited;
    public void dfs(int[][] arr, int cnt, int r, int amount) {
        if (answer < amount)
            return;
        if (cnt == N) {
            if (answer > amount)
                answer = amount;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (r == i)
                continue;
            if (visited[i])
                continue;
            if (i == 0 && cnt < N - 1)
                continue;
            if (arr[r][i] == 0)
                continue;

            int a = arr[r][i];

            visited[i] = true;
            dfs(arr, cnt + 1, i, amount + a);
            visited[i] = false;
        }
    }
}
