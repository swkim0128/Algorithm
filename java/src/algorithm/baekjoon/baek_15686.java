package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_15686 extends Solution {
    int N, M;

    Chicken[] chickens;
    House[] houses;
    int[] minHouses;

    int chickenSize = 0;
    int houseSize = 0;

    int answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        chickens = new Chicken[N * N];
        houses = new House[N * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    houses[houseSize] = new House(i, j);
                    houseSize++;
                }
                else if (map[i][j] == 2) {
                    chickens[chickenSize] = new Chicken(i, j);
                    chickenSize++;
                }
            }
        }

        minHouses = new int[houseSize];
        for (int i = 0; i < houseSize; i++) {
            minHouses[i] = Integer.MAX_VALUE;
        }

        combi(0, 0, minHouses);

        System.out.println(answer);
    }

    public void combi(int cnt, int start, int[] minHouses) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < houseSize; i++) {
                sum += minHouses[i];
            }

            if (answer > sum)
                answer = sum;
            return;
        }

        for (int i = start; i < chickenSize; i++) {
            int[] tempHouses = new int[houseSize];

            for (int j = 0; j < houseSize; j++) {
                tempHouses[j] = distance(chickens[i], houses[j]);

                if (tempHouses[j] > minHouses[j]) {
                    tempHouses[j] = minHouses[j];
                }
            }
            combi(cnt + 1, ++start, tempHouses);
        }
    }

    public int distance(Chicken chicken, House house) {
        return Math.abs(chicken.r - house.r) + Math.abs(chicken.c - house.c);
    }

    class Chicken {
        int r, c;

        Chicken(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class House {
        int r, c;

        House(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}
