package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1961 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            int[][] arr = new int[N][N];

            StringTokenizer token;
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[][] turn1 = turn90(arr);
            int[][] turn2 = turn90(turn1);
            int[][] turn3 = turn90(turn2);

            System.out.println("#" + (t + 1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(turn1[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(turn2[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(turn3[i][j]);
                }
                System.out.println();
            }
        }
    }

    public int[][] turn90(int[][] arr) {
        int N = arr.length;

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[j][N - 1 - i] = arr[i][j];
            }
        }

        return result;
    }
}
