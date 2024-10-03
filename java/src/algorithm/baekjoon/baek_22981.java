package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_22981 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N, K;
        int[] arr;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 팀 중 가장 작은 값 * 팀원 수, 절대값 K/v
    }
}
