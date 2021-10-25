package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_17070 extends Solution {
    int N;
    int[][] map;

    @Override
    public void solution() throws IOException {

        N = Integer.parseInt(read.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int answer = dynamic();
        System.out.println(answer);
    }

    public int dynamic() {
        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 3; k++)
                        dp[i][j][k] = 0;
                }
                else {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
                    dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];

                    if (map[i - 1][j] == 1 || map[i - 1][j - 1] == 1 || map[i][j - 1] == 1) {
                        dp[i][j][1] = 0;
                    }
                    else {
                        dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }
        return 0;
    }

    public int bfs() {
        Queue<Pipe> queue = new LinkedList<>();
        queue.offer(new Pipe(0, 1, 0));

        int cnt = 0;
        while (!queue.isEmpty()) {
            Pipe p = queue.poll();

            if (p.r == N - 1 && p.c == N - 1) {
                cnt++;
                continue;
            }

            Pipe temp = null;
            switch (p.direct) {
                case 0: {
                    temp = width(p);
                    if (temp != null)
                        queue.offer(temp);

                    temp = diagonal(p);
                    if (temp != null) {
                        queue.offer(temp);
                    }
                }
                    break;
                case 1: {
                    temp = width(p);
                    if (temp != null)
                        queue.offer(temp);

                    temp = diagonal(p);
                    if (temp != null) {
                        queue.offer(temp);
                    }

                    temp = height(p);
                    if (temp != null)
                        queue.offer(temp);
                }
                    break;
                case 2: {
                    temp = diagonal(p);
                    if (temp != null) {
                        queue.offer(temp);
                    }

                    temp = height(p);
                    if (temp != null)
                        queue.offer(temp);
                }
                    break;
            }
        }

        return cnt;
    }

    public Pipe width(Pipe p) {
        int nr, nc;

        nr = p.r;
        nc = p.c + 1;

        if (nr != N - 1 && nc == N - 1)
            return null;
        if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
            return null;
        }
        if (map[nr][nc] == 1) {
            return null;
        }

        return new Pipe(nr, nc, 0);
    }

    public Pipe diagonal(Pipe p) {
        int nr, nc;

        nr = p.r + 1;
        nc = p.c + 1;

        if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
            return null;
        }
        if (map[nr][nc - 1] == 1 || map[nr][nc] == 1 || map[nr - 1][nc] == 1) {
            return null;
        }

        return new Pipe(nr, nc, 1);
    }

    public Pipe height(Pipe p) {
        int nr, nc;

        nr = p.r + 1;
        nc = p.c;

        if (nr == N - 1 && nc != N - 1)
            return null;
        if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
            return null;
        }
        if (map[nr][nc] == 1) {
            return null;
        }

        return new Pipe(nr, nc, 2);
    }

    class Pipe {
        int r, c;
        int direct;

        Pipe(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.direct = d;
        }
    }
}
