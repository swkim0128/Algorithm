package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_16162 extends Solution {

    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(token.nextToken());
        int A = Integer.parseInt(token.nextToken());
        int D = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());

        int[] arr = new int[N];
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 음 A를 시작으로 D단씩 증가할 때 X단 출력

        int X = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == A + (X * D)) {
                X++;
            }
        }

        // output
        System.out.println(X);
    }
}
