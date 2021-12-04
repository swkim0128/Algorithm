package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_11562 extends Solution {
    final int INF = 999_999_999;
    int n, m;

    @Override
    public void solution() throws IOException {

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue;
                map[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int u, v, b;

            token = new StringTokenizer(read.readLine(), " ");
            u = Integer.parseInt(token.nextToken());
            v = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());

            if (b == 0) {
                map[u][v] = 0;
                map[v][u] = 1;
            }
            else if (b == 1) {
                map[u][v] = 0;
                map[v][u] = 0;
            }
        }

        fluid(map);

        int k;
        k = Integer.parseInt(read.readLine());
        for (int i = 0; i < k; i++) {
            int s, e;
            token = new StringTokenizer(read.readLine(), " ");

            s = Integer.parseInt(token.nextToken());
            e = Integer.parseInt(token.nextToken());

            if (s == e) {
                System.out.println(0);
            }
            else {
                System.out.println(map[s][e]);
            }
        }
    }

    public void fluid(int[][] map) {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                if (k == i)
                    continue;
                for (int j = 1; j < n + 1; j++) {
                    if (k == j)
                        continue;
                    if (i == j)
                        continue;

                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
    }
}
