package algorithm.programmers;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class progra_test03 extends Solution {

    @Override
    public void solution() throws IOException {
        int n = 5;
        boolean clockwise = false;
        int[][] answer = new int[n][n];

        // n이 1이거나 2일때
        if (n == 1 || n == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    answer[i][j] = 1;
                }
            }
            System.out.println(Arrays.deepToString(answer));
            return;
        }

        ArrayList<Integer> count = new ArrayList<>();
        int c = n - 1;
        while (c >= 0) {
            if (c == 0) {
                count.add(1);
                break;
            }

            count.add(c);
            c -= 2;
        }

        // 시계 방향
        if (clockwise) {
            // 오, 아, 왼, 위
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            // (0, 0)
            int r0 = 0;
            int c0 = -1;
            // (0, 4)
            int r1 = -1;
            int c1 = n - 1;
            // (4, 4)
            int r2 = n - 1;
            int c2 = n;
            // (4, 0)
            int r3 = n;
            int c3 = 0;

            int temp = 1;

            for (int i = 0; i < count.size(); i++) {
                for (int j = 0; j < count.get(i); j++) {
                    r0 = r0 + dr[(i + 0) % 4];
                    c0 = c0 + dc[(i + 0) % 4];

                    r1 = r1 + dr[(i + 1) % 4];
                    c1 = c1 + dc[(i + 1) % 4];

                    r2 = r2 + dr[(i + 2) % 4];
                    c2 = c2 + dc[(i + 2) % 4];

                    r3 = r3 + dr[(i + 3) % 4];
                    c3 = c3 + dc[(i + 3) % 4];

                    answer[r0][c0] = temp;
                    answer[r1][c1] = temp;
                    answer[r2][c2] = temp;
                    answer[r3][c3] = temp;

                    temp++;
                }
            }
        }
        // 반시계 방향
        else {
            // 아, 오, 위, 왼
            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1, 0, -1};
            // (0, 0)
            int r0 = -1;
            int c0 = 0;
            // (4, 0)
            int r1 = n - 1;
            int c1 = -1;
            // (4, 4)
            int r2 = n;
            int c2 = n - 1;
            // (0, 4)
            int r3 = 0;
            int c3 = n;

            int temp = 1;
            for (int i = 0; i < count.size(); i++) {
                for (int j = 0; j < count.get(i); j++) {
                    r0 = r0 + dr[(i + 0) % 4];
                    c0 = c0 + dc[(i + 0) % 4];

                    r1 = r1 + dr[(i + 1) % 4];
                    c1 = c1 + dc[(i + 1) % 4];

                    r2 = r2 + dr[(i + 2) % 4];
                    c2 = c2 + dc[(i + 2) % 4];

                    r3 = r3 + dr[(i + 3) % 4];
                    c3 = c3 + dc[(i + 3) % 4];

                    answer[r0][c0] = temp;
                    answer[r1][c1] = temp;
                    answer[r2][c2] = temp;
                    answer[r3][c3] = temp;

                    temp++;
                }
            }
        }
    }
}