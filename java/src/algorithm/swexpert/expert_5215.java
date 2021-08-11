package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_5215 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int N = Integer.parseInt(token.nextToken());
            int L = Integer.parseInt(token.nextToken());

            int[] T = new int[N];
            int[] K = new int[N];

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                T[i] = Integer.parseInt(token.nextToken());
                K[i] = Integer.parseInt(token.nextToken());
            }

            int total = 1 << N;
            int max = 0;

            for (int i = 1 ; i < total + 1; i++) {
                int sumT = 0;
                int sumK = 0;
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) == 0)
                        continue;

                    sumT += T[j];
                    sumK += K[j];

                }

                if (sumK > L)
                    continue;

                if (answer[t] < sumT) {
                    answer[t] = sumT;
                }
            }
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
