package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_21758 extends Main {
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(read.readLine());
        int[] H = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(token.nextToken());
        }

        // algo

        // 가장 작은 수에서 시작하는 위치 하나
        int min = 999999;
        int minIdx = 0;
        for (int i = 0; i < N; i++) {
            if (min > H[i]) {
                min = H[i];
                minIdx = i;
            }
        }

        // 가장 멀리 시작하는 위치 하나 -> 시작점과 끝점
        int sum01 = 0;
        for (int i = 1; i < N; i++) {
            // 또 다른 위치 건너뛰기
            if (minIdx == i) {
                continue;
            }

            sum01 += H[i];
            if (minIdx < i) {
                sum01 += H[i];
            }
        }

        int sum02 = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (minIdx == i) {
                continue;
            }

            sum02 += H[i];
            if (i < minIdx) {
                sum02 += H[i];
            }
        }

        if (sum01 < sum02) {
            System.out.println(sum02);
        }
        else {
            System.out.println(sum01);
        }
    }

    static {
        try {
            new baek_21758().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
