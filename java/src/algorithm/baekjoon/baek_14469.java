package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_14469 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N;
        int[][] arr;

        N = Integer.parseInt(read.readLine());
        arr = new int[N][2];

        // 도착 시간, 검문 걸리는 시간
        for (int i = 0; i < N; i++) {
            int a, b;

            StringTokenizer token = new StringTokenizer(read.readLine());
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }

        // algo
        // 도착 시간, 검문 걸리는 시간 순으로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });


    }
}
