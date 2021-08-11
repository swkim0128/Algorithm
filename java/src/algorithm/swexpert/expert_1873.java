package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1873 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int H, W;
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            H = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());

            char[][] map = new char[H][W];

            for (int i = 0; i < H; i++) {
                map[i] = read.readLine().toCharArray();
            }

            int N = Integer.parseInt(read.readLine());
            char[] order = read.readLine().toCharArray();

            int tankPosR = 0, tankPosC = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    switch (map[i][j]) {
                        case '<':
                        case '>':
                        case '^':
                        case 'v':
                            tankPosR = i;
                            tankPosC = j;
                            break;
                    }
                }
            }

            int moveR = 0;
            int moveC = 0;
            int shootR = 0;
            int shootC = 0;

            for (int i = 0; i < N; i++) {
                if (order[i] == 'S') {
                    switch (map[tankPosR][tankPosC]) {
                        case '^':
                            shootR = -1;
                            shootC = 0;
                            break;
                        case 'v':
                            shootR = 1;
                            shootC = 0;
                            break;
                        case '<':
                            shootR = 0;
                            shootC = -1;
                            break;
                        case '>':
                            shootR = 0;
                            shootC = 1;
                            break;
                    }

                    int bulletR = tankPosR;
                    int bulletC = tankPosC;
                    while ((0 <= bulletR && bulletR < H) && (0 <= bulletC && bulletC < W)) {
                        if (map[bulletR][bulletC] == '*') {
                            map[bulletR][bulletC] = '.';
                            break;
                        }
                        else if (map[bulletR][bulletC] == '#') {
                            break;
                        }

                        bulletR += shootR;
                        bulletC += shootC;
                    }
                }
                else {
                    switch (order[i]) {
                        case 'U':
                            moveR = -1;
                            moveC = 0;
                            map[tankPosR][tankPosC] = '^';
                            break;
                        case 'D':
                            moveR = 1;
                            moveC = 0;
                            map[tankPosR][tankPosC] = 'v';
                            break;
                        case 'L':
                            moveR = 0;
                            moveC = -1;
                            map[tankPosR][tankPosC] = '<';
                            break;
                        case 'R':
                            moveR = 0;
                            moveC = 1;
                            map[tankPosR][tankPosC] = '>';
                            break;
                    }

                    if (tankPosR + moveR < 0 || H <= tankPosR + moveR || tankPosC + moveC < 0 || W <= tankPosC + moveC) {
                        continue;
                    }
                    if (map[tankPosR + moveR][tankPosC + moveC] == '.') {
                        char temp = map[tankPosR][tankPosC];
                        map[tankPosR][tankPosC] = '.';
                        tankPosR += moveR;
                        tankPosC += moveC;
                        map[tankPosR][tankPosC] = temp;
                    }
                }
            }

            System.out.print("#" + (t + 1) + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
