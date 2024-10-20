package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_2160 extends Main {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        final int row = 5;
        final int col = 7;

        char[][][] arr = new char[N][row][col];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < row; j++) {
                String str = scan.next();
                arr[i][j] = str.toCharArray();
            }
        }

        int answer = Integer.MAX_VALUE;
        int answerA = 0, answerB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = 0;

                for (int k = 0; k < row; k++) {
                    for (int l = 0; l < col; l++) {
                        if (arr[i][k][l] != arr[j][k][l]) {
                            temp++;
                        }
                    }
                }

                if (answer > temp) {
                    answer = temp;
                    answerA = i + 1;
                    answerB = j + 1;
                }
            }
        }

        System.out.println(answerA + " " + answerB);
    }
    static {
        new baek_2160().run();
    }
}
