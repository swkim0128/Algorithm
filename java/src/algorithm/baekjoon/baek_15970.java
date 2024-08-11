package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_15970 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        int[][] arr = new int[N][2];
        for (int n = 0; n < N; n++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            arr[n][0] = x;
            arr[n][1] = y;
        }

        // algo
        int result = 0;

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        for (int n = 0; n < N; n++) {
            int r = 0;

            if (n == 0) {
                r = arr[n][1] == arr[n + 1][1] ? arr[n + 1][0] - arr[n][0] : 0;
            }
            else if (n == N - 1) {
                r = arr[n][1] == arr[n - 1][1] ? arr[n][0] - arr[n - 1][0] : 0;
            }
            else {
                int tmp1 = arr[n][0] - arr[n - 1][0];
                int tmp2 = arr[n + 1][0] - arr[n][0];

                if (arr[n][1] == arr[n - 1][1] && arr[n][1] == arr[n + 1][1]) {
                    r = Math.min(tmp1, tmp2);
                }
                else if (arr[n][1] != arr[n - 1][1] && arr[n][1] == arr[n + 1][1]) {
                    r = tmp2;
                }
                else if (arr[n][1] == arr[n - 1][1] && arr[n][1] != arr[n + 1][1]) {
                    r = tmp1;
                }
            }

            result += r;
        }

        // output
        System.out.println(result);
    }
}
