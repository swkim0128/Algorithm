package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1940 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];
        StringTokenizer token;

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            int command = 0;
            int a = 0;

            int v = 0;
            int distance = 0;
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                command = Integer.parseInt(token.nextToken());

                if (command != 0) {
                    a = Integer.parseInt(token.nextToken());
                }

                switch (command) {
                    case 0:
                        break;
                    case 1:
                        v += a;
                        break;
                    case 2:
                        v -= a;

                        if (v < 0)
                            v = 0;
                        break;
                }

                distance += v;
            }

            answer[t] = distance;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
