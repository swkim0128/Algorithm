package algorithm.programmers;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class progra_test02 extends Solution {
    int N, M;
    Arr[][] arr;

    int startR = 0;
    int startC = 0;
    int startD = 0;

    ArrayList<Integer> ans = new ArrayList<>();

    @Override
    public void solution() throws IOException {
        String[] grid = read.readLine().split(" ");
        N = grid.length;
        M = grid[0].length();

        arr = new Arr[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = new Arr(grid[i].charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    if (arr[i][j].direc[k])
                        continue;

                    arr[i][j].direc[k] = true;
                    dfs(i, j, k, 1);
                }
            }
        }

        int[] answer = new int[ans.size()];
        int size = 0;
        for (int i : ans) {
            answer[size++] = i;
        }

        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void dfs(int r, int c, int d, int amount) {

        int nr = r + dr[d];
        int nc = c + dc[d];

        nr = (nr + N) % N;
        nc = (nc + M) % M;

        if (arr[nr][nc].data == 'S') {
            d = d;
        }
        else if (arr[nr][nc].data == 'L') {
            // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2
            d = (d + 3) % 4;
        }
        else if (arr[nr][nc].data == 'R') {
            // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0
            d = (d + 1) % 4;
        }

        if (arr[nr][nc].direc[d]) {
            ans.add(amount);
            return;
        }

        arr[nr][nc].direc[d] = true;
        dfs(nr, nc, d, amount + 1);
    }

    class Arr {
        char data;
        boolean[] direc = new boolean[4];

        Arr(char c) {
            this.data = c;
        }
    }
}
