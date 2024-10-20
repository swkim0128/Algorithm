package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_10570 extends Main {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        final int SOfSize = 1001;

        int testCase = scan.nextInt();

        for (int j = 0; j < testCase; j++) {
            int[] S = new int[SOfSize];
            int V = scan.nextInt();

            int temp;
            for (int i = 0; i < V; i++) {
                temp = scan.nextInt();
                S[temp]++;
            }

            int answer = 0;
            int answerIndex = 0;
            for (int i = 0; i < SOfSize; i++) {
                if (answer < S[i]) {
                    answer = S[i];
                    answerIndex = i;
                }
            }

            System.out.println(answerIndex);
        }
    }
    static {
        new baek_10570().run();
    }
}
