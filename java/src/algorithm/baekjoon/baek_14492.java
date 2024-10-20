package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_14492 extends Main {
    public void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[][] arrA = new int[N][N];
        int[][] arrB = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrA[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arrB[i][j] = scan.nextInt();
            }
        }

        int[][] arrC = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arrC[i][j] |= (arrA[i][k] & arrB[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrC[i][j] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
    public void run(int[] arr) {

    }
    static {
        new baek_14492().run();
    }
}
