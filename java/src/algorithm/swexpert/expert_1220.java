package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1220 extends Solution {
    @Override
    public void solution() throws IOException {
        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(read.readLine());

            int[][] arr = new int[N][N];
            StringTokenizer token;

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            // 1이 밑으로 2가 위로
            int answer = 0;
            for (int j = 0; j < N; j++) {
                boolean isConflict = false;
                int oneP = 0, twoP = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 1) {
                        isConflict = true;
                        oneP = i;
                    }
                    else if (arr[i][j] == 2) {
                        twoP = i;
                        if (isConflict) {
                           answer++;
                        }
                        isConflict = false;
                    }
                }
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }
}
