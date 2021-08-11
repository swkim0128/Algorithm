package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_3499 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            String[] cards = new String[N];
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            for (int i = 0; i < N; i++) {
                cards[i] = token.nextToken();
            }

            int[] shuffleCards = new int[N];

            if (N % 2 == 0) {
                for (int i = 0; i < N / 2; i++) {
                    shuffleCards[i * 2] = i;
                }

                int odd = 1;
                for (int i = N / 2; i < N; i++) {
                    shuffleCards[odd] = i;
                    odd += 2;
                }
            }
            else {
                for (int i = 0; i < N / 2 + 1; i++) {
                    shuffleCards[i * 2] = i;
                }

                int odd = 1;
                for (int i = N / 2 + 1; i < N; i++) {
                    shuffleCards[odd] = i;
                    odd += 2;
                }
            }

            System.out.print("#" + (t + 1) + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(cards[shuffleCards[i]] + " ");
            }
            System.out.println();
        }
    }
}
