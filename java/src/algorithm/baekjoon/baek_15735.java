package algorithm.baekjoon;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class baek_15735 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);

        final int MAX_ARR = 100001;
        int N = scan.nextInt();
        long[] S = new long[MAX_ARR];
        long[] sumArr = new long[MAX_ARR];

        S[1] = 1;
        sumArr[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            S[i] += S[i - 1];

            for (int j = 1; j < i + 1; j++) {
                if (i / j >= 2) {
                    sumArr[j] += 2;
                }
                else {
                    sumArr[j] += 1;
                }

                S[i] += sumArr[j];
            }
        }

        System.out.println(S[N]);
    }
}
