package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_17124 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int T = Integer.parseInt(read.readLine());
        int[] result = new int[T];

        StringTokenizer tokenizer = null;
        for (int t = 0; t < T; t++) {
            tokenizer = new StringTokenizer(read.readLine());

            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            tokenizer = new StringTokenizer(read.readLine());
            for (int n = 0; n < N; n++) {
                A[n] = Integer.parseInt(tokenizer.nextToken());
            }

            tokenizer = new StringTokenizer(read.readLine());
            for (int m = 0; m < M; m++) {
                B[m] = Integer.parseInt(tokenizer.nextToken());
            }

            // algo
            int[] C = new int[N];

            for (int i = 0; i < N; i++) {
                //  절대값 차이가 가장 작은 값
                int c = 0;
                int cAbs = 999999999;
                int idx = 0;
                for (int j = 0; j < M; j++) {
                    int tmp = Math.abs(B[j] - A[i]);

                    //  기존 절대값보다 작으면
                    if (cAbs > tmp) {
                        c = B[j];
                        cAbs = tmp;
                        idx = j;
                    }
                    //  기존 절대값이 같으면
                    else if (cAbs == tmp) {
                        //  기존 값보다 작으면
                        if (B[idx] > B[j]) {
                            c = B[j];
                            idx = j;
                        }
                    }
                }

                C[i] = c;
            }

            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += C[j];
            }

            result[t] = sum;
        }

        // output
        for (int t = 0; t < T; t++) {
            System.out.println(result[t]);
        }
    }
    static {
        try {
            new baek_17124().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
