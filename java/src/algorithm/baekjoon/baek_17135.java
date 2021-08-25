package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_17135 extends Solution {
    int N, M, D;
    int[][] map;

    final int ARCHERS_SIZE = 3;
    Archer[] archers = new Archer[ARCHERS_SIZE];

    int answer = 0;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int[] p = new int[M];
        for (int i = M - 1; i >= M - 3; i--) {
            p[i] = 1;
        }

        do {
            int n = 0;
            for (int i = 0; i < M; i++) {
                if (p[i] == 1) {
                    archers[n] = new Archer(N, i);
                    n++;
                }
            }

            turnGame();
        } while (nb(p));

//        combi(0, 0);

        System.out.println(answer);
    }

    public boolean nb(int[] numbers) {
        int N = numbers.length;

        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i])
            i--;

        if (i == 0)
            return false;

        int j = N - 1;
        while (numbers[i - 1] >= numbers[j])
            j--;

        swap(numbers, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(numbers, i, k);
            i++;
            k--;
        }

        return true;
    }

    public void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }

    public void combi(int cnt, int start) {
        if (cnt == ARCHERS_SIZE) {
            turnGame();
            return;
        }

        for (int i = start; i < M; i++) {
            archers[cnt] = new Archer(N, i);
            combi(cnt + 1, ++start);
        }
    }

    public void turnGame() {
        int sum = 0;
        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int n = 0; n < N; n++) {
            sum += shootArcher(tempMap);

            for (int i = N - 1; i > 0; i--) {
                for (int j = 0; j < M; j++) {
                    tempMap[i][j] = tempMap[i - 1][j];
                }
            }

            for (int j = 0; j < M; j++) {
                tempMap[0][j] = 0;
            }
        }

        if (answer < sum) {
            answer = sum;
        }
    }

    public int shootArcher(int[][] map) {
        int result = 0;
        Enemy[] enemies = new Enemy[ARCHERS_SIZE];

        for (int n = 0; n < ARCHERS_SIZE; n++) {
            int minD = Integer.MAX_VALUE;

            for (int j = 0; j < M; j++) {
                for (int i = N - 1; i >= N - D; i--) {
                    if (map[i][j] == 0)
                        continue;
                    int temp = distance(archers[n], i, j);
                    if (temp <= D) {
                        if (minD > temp) {
                            minD = temp;
                            enemies[n] = new Enemy(i, j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < ARCHERS_SIZE; i++) {
            if (enemies[i] == null) continue;
            if (map[enemies[i].r][enemies[i].c] == 1) {
                map[enemies[i].r][enemies[i].c] = 0;
                result++;
            }
        }

        return result;
    }

    public int distance(Archer archer, int r, int c) {
        return Math.abs(archer.r - r) + Math.abs(archer.c - c);
    }

    class Archer {
        int r, c;

        Archer(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class Enemy{
        int r, c;

        Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
