/*
[입력]
N

[run]
1. 입력을 받는다.
2. 적록색약이 아닌 경우, 적록색약인 경우로 나누어 접근한다.
3. 그래프 탐색을 이용하여 적록색약의 구역을 확인한다.
*/
package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class baek_10026 extends Main {
    // N
    static int N;

    // 격자
    static String[][] MAT = new String[101][101];
    // 격자의 방문 여부
    static boolean[][] visited = new boolean[101][101];

    // 동, 남, 서, 북
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    // 적록색약 x, 적록색약 o
    static int cnt, cnt2;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String[] str = sc.next().split("");
            for (int j = 0; j < N; j++) {
                MAT[i][j] = str[j];
            }
        }

        // 적록색약 X
        for (int i = 0; i < N; i++) {
            for (int j = 0; j< N; j++) {
                if (visited[i][j] == false) {
                    visited[i][j] = true;
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);

        // 적록색약 O 인 경우
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (MAT[i][j].equals( "G")) {
                    MAT[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    visited[i][j] = true;
                    cnt2++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt2);
    }

    public void dfs(int row, int col) {
        // 종료 조건
        String nowRGB = MAT[row][col];

        // 탐색 조건
        for (int i = 0; i < 4; i++) {
            int nxtRow = row + dr[i];
            int nxtCol = col + dc[i];

            if (0 <= nxtRow && nxtRow < N && 0 <= nxtCol && nxtCol < N) {
                if (visited[nxtRow][nxtCol] == false && MAT[nxtRow][nxtCol].equals(nowRGB)) {
                    visited[nxtRow][nxtCol] = true;
                    dfs(nxtRow, nxtCol);
                }
            }
        }
    }
    static {
        try {
            new baek_10026().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}