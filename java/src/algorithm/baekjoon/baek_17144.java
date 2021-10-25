package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_17144 extends Solution {
    int R, C, T;
    int[][] map;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");


        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        ArrayList<Data> airCon = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());

                if (map[i][j] == -1)
                    airCon.add(new Data(i, j));
            }
        }

        for (int t = 0; t < T; t++) {
            bfs();
            moveAir(airCon);
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    answer += map[i][j];
            }
        }

        System.out.println(answer);
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void bfs() {
        ArrayList<Data> monji = getMonji();

        while (!monji.isEmpty()) {
            Data d = monji.remove(0);

            int r = d.r, c = d.c;
            int nr, nc;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (map[nr][nc] == -1)
                    continue;

                map[nr][nc] += d.d / 5;
                cnt++;
            }

            map[r][c] = map[r][c] - (d.d / 5) * cnt;
        }
    }

    public ArrayList<Data> getMonji() {
        ArrayList<Data> monji = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    monji.add(new Data(i, j, map[i][j]));
            }
        }

        return monji;
    }

    public void moveAir(ArrayList<Data> airCon) {
        Data up = airCon.get(0);
        Data down = airCon.get(1);

        int r = up.r, c = up.c;
        int nr, nc;
        int d = 0;
        while (true) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < 0 || down.r <= nr || nc < 0 || C <= nc) {
                d++;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            if (map[nr][nc] == -1) {
                map[r][c] = 0;
                break;
            }

            if (r == up.r && c == up.c) {
                map[nr][nc] = -1;
            }
            map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
        }

        r = down.r;
        c = down.c;
        d = 2;
        while (true) {
            nr = r + dr[d];
            nc = c + dc[d];

            if (nr < down.r || R <= nr || nc < 0 || C <= nc) {
                d = (d + 3) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            if (map[nr][nc] == -1) {
                map[r][c] = 0;
                break;
            }

            if (r == down.r && c == down.c) {
                map[nr][nc] = -1;
            }
            map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
        }
    }

    class Data {
        int r, c, d;

        Data(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Data(int r, int c, int d) {
            this(r, c);
            this.d = d;
        }
    }
}
