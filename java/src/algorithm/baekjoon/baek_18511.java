package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class
baek_18511 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        String N = token.nextToken();
        int K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());

        int[] arr = new int[K];
        for (int k = 0; k < K; k++) {
            arr[k] = Integer.parseInt(token.nextToken());
        }

        // algo
        // N보다 작거나 같은 자연수 중에서, 집합 K의 원소로만 구성된 가장 큰 수
        Arrays.sort(arr);
        String result = dfs(0, arr, Integer.parseInt(N), N.length(), K);

        // output
        System.out.println(result);
    }

    public String dfs(int n, int[] arr, int N, int Nlen, int K) {
        if (n == Nlen) {
            return "";
        }

        String result = "";
        for (int i = K - 1; i >= 0; i--) {
            int tmp = arr[i];
            String tmpStr = tmp + dfs(n + 1, arr, N, Nlen, K);

            if (Integer.parseInt(tmpStr) < N) {
                break;
            }
        }

        return result;
    }
    static {
        try {
            new baek_18511().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
