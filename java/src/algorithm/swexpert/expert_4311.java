package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_4311 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.getInteger(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N, O, M;

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            O = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(read.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(token.nextToken());
            }

            token = new StringTokenizer(read.readLine(), " ");
            for (int i = 0; i < O; i++) {
                int o = Integer.parseInt(token.nextToken());
            }

            int target = Integer.parseInt(read.readLine());
        }
    }
}
