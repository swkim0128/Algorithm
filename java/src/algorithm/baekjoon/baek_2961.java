package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_2961 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        int[] S = new int[N];
        int[] B = new int[N];

        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            S[i] = Integer.parseInt(token.nextToken());
            B[i] = Integer.parseInt(token.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << N); i++) {
            int mul = 1;
            int sum = 0;

            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) == 0) continue;

                mul *= S[j];
                sum += B[j];
            }

            if (min > Math.abs(mul - sum)) {
                min = Math.abs(mul - sum);
            }
        }

        System.out.println(min);
    }
}
