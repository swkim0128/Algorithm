package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_14400 extends Solution {
    @Override
    public void solution() throws IOException {
        int N;
        int[] xArr;
        int[] yArr;

        // input
        N = Integer.parseInt(read.readLine().trim());
        xArr = new int[N];
        yArr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            xArr[i] = Integer.parseInt(token.nextToken());
            yArr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int idx = N / 2;
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(xArr[i] - xArr[idx]);
            result += Math.abs(yArr[i] - yArr[idx]);
        }

        // output
        System.out.println(result);
    }
}
