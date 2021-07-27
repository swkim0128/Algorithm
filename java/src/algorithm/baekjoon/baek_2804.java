package algorithm.baekjoon;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class baek_2804 implements SolutionImpl {
    public void solution() {
        Scanner scan = new Scanner(System.in);

        String A = scan.next();
        String B = scan.next();
        int N = A.length();
        int M = B.length();

        char[][] answer = new char[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = '.';
            }
        }

        int startAIndex = 0;
        int startBIndex = 0;

        forloop: for (int i = 0; i < N; i++) {
            char temp = A.charAt(i);
            for (int j = 0; j < M; j++) {
                if (temp == B.charAt(j)) {
                    startAIndex = j;
                    startBIndex = i;
                    break forloop;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer[startAIndex][i] = A.charAt(i);
        }

        for (int i = 0; i < M; i++) {
            answer[i][startBIndex] = B.charAt(i);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}
