package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1445 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N, M;
        char[][] map;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = read.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        // algo
        // 형택이는 그동안 여자친구와 사귀면서 2가지 깨달은 것이 있는데,
        // 한 가지는 쓰레기를 통과해서 지나가는 것을 정말 싫어하는 것이고,
        // 쓰레기를 따라 옆을 지나가는 것도 정말 불편하게 느낀다는 것이다.

        // 입력으로 숲의 지도가 주어진다. S는 형택이와 여자친구의 데이트 시작장소를 나타내고,
        // F는 꽃이 있는 위치를 나타내고, g는 쓰레기가 있는 위치를 나타낸다.
        // 그리고 .은 아무것도 없는 깨끗한 칸이다.
        // S -> F,

        int startR = 0, startC = 0;
        int endR = 0, endC = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
                else if (map[i][j] == 'F') {
                    endR = i;
                    endC = j;
                }
                else if (map[i][j] == 'g') {
                    for (int k = 0; k < 4; k++) {
                        int nr = dr[k] + i;
                        int nc = dc[k] + j;

                        if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                            continue;
                        }
                        map[nr][nc] = 'G';
                    }
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int trash = 9999999;
        int side = 9999999;

        queue.add(new Point(startR, startC, 0, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + p.r;
                int nc = dc[i] + p.c;

                if (nr < 0 || N <= nr || nc < 0 || M <= nc) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                if (nr == endR && nc == endC) {
                    if (p.trashCnt <= trash) {
                        trash = p.trashCnt;
                    }
                    if (p.sideCnt <= side) {
                        side = p.sideCnt;
                    }
                    continue;
                }

                int trashCnt = p.trashCnt;
                int sideCnt = p.sideCnt;
                if (map[nr][nc] == 'g') {
                    trashCnt++;
                }
                else if (map[nr][nc] == 'G') {
                    sideCnt++;
                }

                queue.add(new Point(nr, nc, trashCnt, sideCnt));
                visited[nr][nc] = true;
            }
        }

        System.out.println(trash + " " + side);
    }

    private static class Point {
        int r, c;
        int trashCnt, sideCnt;

        Point(int r, int c, int trashCnt, int sideCnt) {
            this.r = r;
            this.c = c;
            this.trashCnt = trashCnt;
            this.sideCnt = sideCnt;
        }
    }
    static {
        try {
            new baek_1445().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
