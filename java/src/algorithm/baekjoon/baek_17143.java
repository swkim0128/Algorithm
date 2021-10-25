package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_17143 extends Solution {
    int R, C, M;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        R = Integer.getInteger(token.nextToken());
        C = Integer.getInteger(token.nextToken());
        M = Integer.getInteger(token.nextToken());

        Shark[] sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            int r, c, s, d, z;

            r = Integer.getInteger(token.nextToken());
            c = Integer.getInteger(token.nextToken());
            s = Integer.getInteger(token.nextToken());
            d = Integer.getInteger(token.nextToken());
            z = Integer.getInteger(token.nextToken());
            sharks[i] = new Shark(r, c, s, d, z);
        }

        int answer = 0;

        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.getInteger(token.nextToken());
            }
        }
    }

    class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public void move() {
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, 1, -1};

            int row = R - 1;
            int col = C - 1;

            int nr, nc;

            switch (d) {
                case 1: {
                    int tempS = s % (row * 2);

                    if (r <= tempS && tempS < r + row) {
                        d = 2;
                        r = 1 + (tempS - r + 1);
                    }
                    else if (tempS < r) {
                        r = r - tempS;
                    }
                    else if (r + row <= tempS) {
                        r = r + (row * 2 - tempS);
                    }
                }
                    break;
                case 2: {
                    int tempS = s % (row * 2);

                    if (r <= tempS && tempS < r + row) {
                        d = 1;
                        r = 1 + (tempS - r + 1);
                    }
                    else if (tempS < r) {
                        r = r - tempS;
                    }
                    else if (r + row <= tempS) {
                        r = r + (row * 2 - tempS);
                    }
                }
                    break;
                case 3: {
                    int tempS = s % (col * 2);

                    if (c <= tempS && tempS < c + col) {
                        d = 4;
                        c = 1 + (tempS - c + 1);
                    }
                    else if (tempS < c) {
                        c = c - tempS;
                    }
                    else if (c + col <= tempS) {
                        c = c + (col * 2 - tempS);
                    }
                }
                    break;
                case 4: {
                    int tempS = s % (col * 2);

                    if (c <= tempS && tempS < c + col) {
                        d = 3;
                        c = 1 + (tempS - c + 1);
                    }
                    else if (tempS < c) {
                        c = c - tempS;
                    }
                    else if (c + col <= tempS) {
                        c = c + (col * 2 - tempS);
                    }
                }
                    break;
            }
        }
    }
}
