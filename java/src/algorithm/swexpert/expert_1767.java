package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class expert_1767 extends Solution {
    int N;
    int[][] arr;

    int coreCnt = 0;
    int answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(read.readLine());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            ArrayList<Point> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1 && ((i == 0 || i == N - 1) || (j == 0 || j == N - 1)))
                        continue;
                    else if (arr[i][j] == 1) {
                        list.add(new Point(i, j));
                    }
                }
            }

            getAnswer(list, 0, 0, 0);

            System.out.println("#" + (t + 1) + " " + answer);
            coreCnt = 0;
            answer = Integer.MAX_VALUE;
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void getAnswer(ArrayList<Point> list, int n, int cCnt, int amount) {
        if (n == list.size()) {
            if (coreCnt < cCnt) {
                answer = amount;
                coreCnt = cCnt;
            }
            else if (coreCnt == cCnt && answer > amount) {
                answer = amount;
            }
            return;
        }

        boolean isNoLines = true;
        for (int i = 0; i < 4; i++) {
            int a = drawLine(list.get(n), i);
            if (a == -1) {
                continue;
            }
            else {
                isNoLines = false;
                getAnswer(list, n + 1, cCnt + 1, amount + a);
                eraseLine(list.get(n), i);
            }
        }

        getAnswer(list, n + 1, cCnt, amount);
    }

    public int drawLine(Point p, int d) {
        int r = p.r, c = p.c;
        int nr, nc;
        int result = 0;

        while (true) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
                break;
            }
            if (arr[nr][nc] == 2 || arr[nr][nc] == 1) {
                result = -1;
                break;
            }

            result++;
            arr[nr][nc] = 2;
            r = nr;
            c = nc;
        }

        int eraseR = nr;
        int eraseC = nc;
        if (result == -1) {
            r = p.r;
            c = p.c;

            while (true) {
                nr = r + dr[d];
                nc = c + dc[d];

                if (nr == eraseR && nc == eraseC)
                    break;

                arr[nr][nc] = 0;
                r = nr;
                c = nc;
            }
        }

        return result;
    }

    public void eraseLine(Point p, int d) {
        int r = p.r, c = p.c;
        int nr, nc;

        while (true) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || N <= nr || nc < 0 || N <= nc) {
                break;
            }
            if (arr[nr][nc] == 1) {
                break;
            }

            arr[nr][nc] = 0;
            r = nr;
            c = nc;
        }
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
