package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_11985 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N, M, K;
        int[] arr;

        StringTokenizer token = new StringTokenizer(read.readLine());

        // 오렌지 개수, 개수 최대값, 포장 비용
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        arr = new int[N];
        // 오렌지의 크기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        // 모든 오렌지를 포장하는 비용 치소값
        // 한 상자에는 최대 M개의 오렌지를 넣을 수 있다.
        // 상자에 오렌지를 넣는 비용은 K + s × (a − b) 로 구할 수 있다.
        // 여기서 a는 상자에 넣은 가장 큰 오렌지의 크기,
        // b는 상자에 넣은 가장 작은 오렌지의 크기,
        // s는 상자에 넣은 오렌지의 개수이다.
        // K는 상자를 포장하는 비용이고, 모든 상자에 공통적으로 적용되는 값이다.

        // algo
        int[] mArr = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            // j ~ j + i
            for (int j = 0; j < N; j++) {
//                int tmp = K + i * (a - b);
            }
        }
    }
}
