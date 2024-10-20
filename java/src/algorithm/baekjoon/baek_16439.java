package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16439 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer tokenizer = new StringTokenizer(read.readLine());

        //  회원
        int N = Integer.parseInt(tokenizer.nextToken());
        // 치킨 종류
        int M = Integer.parseInt(tokenizer.nextToken());

        int[][] favor = new int[N][M];
        boolean[] selected = new boolean[M];

        for (int n = 0; n < N; n++) {
            tokenizer = new StringTokenizer(read.readLine());

            // 각 치킨 선호도
            for (int m = 0; m < M; m++) {
                favor[n][m] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        // algo
        // 최대 세 종류의 치킨을 골라 가장 숫자가 큰 값 선택
        // M개 중에서 3개 선택하는 algo

        int result = 0;

        for (int m1 = 0; m1 < M; m1++) {
            for (int m2 = m1 + 1; m2 < M; m2++) {
                for (int m3 = m2 + 1; m3 < M; m3++) {
                    int sum = 0;

                    for (int n = 0; n < N; n++) {

                        int maxN = max(favor[n][m1], favor[n][m2], favor[n][m3]);
                        sum += maxN;
                    }

                    result = Math.max(result, sum);
                }
            }
        }

        // output
        System.out.println(result);
    }

    public int max(int i, int j, int k) {
        int tmp = Math.max(i, j);
        return Math.max(tmp, k);
    }
    static {
        try {
            new baek_16439().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
