package algorithm.swexpert;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class expert_1954 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        for (int t = 0; t < testCase; t++) {
            int n = scan.nextInt();

            int[][] snail = new int[n][n];
            boolean[][] visited = new boolean[n][n];

            int snailNum = 1;
            int row = 0;
            int column = 0;

            int tempRow = 0, tempColumn = 0;

            int nextD = 0;

            while (true) {
                snail[row][column] = snailNum;
                visited[row][column] = true;

                tempRow = row + dr[nextD];
                tempColumn = column + dc[nextD];

                if (tempRow < 0 || n <= tempRow || tempColumn < 0 || n <= tempColumn) {
                    nextD = (nextD + 1) % 4;
                }
                else if (visited[tempRow][tempColumn]) {
                    nextD = (nextD + 1) % 4;
                }

                row += dr[nextD];
                column += dc[nextD];
                snailNum++;

                if (snailNum == n * n + 1)
                    break;
            }

            System.out.println("#" + (t + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }

//        public void reculsive(int row, int column, int n) {
//
//
//        }
    }
}
