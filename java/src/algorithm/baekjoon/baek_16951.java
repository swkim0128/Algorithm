package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16951 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        int result = 0;

        // 이전과의 높이가 K 값이 아닐 때, 작업 시간++
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i - 1] != K) {
                result++;
                arr[i] = arr[i - 1] + K;
            }
        }

        // output
        System.out.println(result);
    }
    static {
        try {
            new baek_16951().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
