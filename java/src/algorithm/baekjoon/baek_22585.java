package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_22585 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N, K;
        int[] S, D;

        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        S = new int[N];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(token.nextToken());
        }

        D = new int[N];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // K번 셔플한 카드와 D의 정보를 알때, 원래 배열을 구하기
        // 각 i에 대해 D_i번째 카드를 i번째로 가져오는 작업을 셔플

        // 예를 들어, P_1, P_2, ..., P_N이 1, 4, 5, 3, 2이고,
        // D_1, D_2, ..., D_N가 4, 3, 1, 2, 5라고 가정해보자. 이 카드를 한번 섞으면 3, 5, 1, 4, 2가 된다.
        // 4 -> 1, 3 -> 2, 1 -> 3, 2 -> 4, 5 -> 5

        // 1 4 5 3 2
        // -> 3 5 1 4 2
        // -> 4 1 3 5 2
        // 4 3 1 2 5

        int[] sClone = S.clone();
        for (int k = 0; k < K; k++) {
            int[] result = new int[N];

            for (int i = 0; i < N; i++) {
                int j = D[i];
                result[j - 1] = sClone[i];
            }

            sClone = result.clone();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(sClone[i] + " ");
        }
    }
    static {
        try {
            new baek_22585().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
