package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_5656 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N, W, H;

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());
            H = Integer.parseInt(token.nextToken());

            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }


        }
    }
}
