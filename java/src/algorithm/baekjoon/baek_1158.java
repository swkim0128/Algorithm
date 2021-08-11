package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_1158 extends Solution {
    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int n = -1;
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                n = (n + 1) % N;

                while (arr[n] == 0) {
                    n = (n + 1) % N;
                }
            }

            answer[i] = arr[n];
            arr[n] = 0;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
