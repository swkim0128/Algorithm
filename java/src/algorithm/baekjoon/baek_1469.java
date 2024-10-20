package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1469 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());
        StringTokenizer token = new StringTokenizer(read.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        int[] S = new int[N * 2];
        boolean[] visited = new boolean[N];

        dfs(0, S, visited, arr, N);

        // output
    }

    public void dfs(int n, int[] S, boolean[] visited, int[] arr, int N) {
        // return
//        boolean isEnd = false;
//        for (int i = 0; i < N; i++) {
//            if (visited[i]) isEnd = true;
//            else {
//                isEnd = false;
//                break;
//            }
//        }
//
//        if (isEnd) return;
        if (n == N) return;

        for (int i = 0; i < N; i++) {
            int tmp = arr[i];

            if (N * 2 <= n + tmp + 1) continue;
            if (visited[i]) continue;

            // tmp 사이 수는 tmp개
            int prev = S[n];
            S[n] = tmp;
            S[n + tmp + 1] = tmp;

            visited[i] = true;
            dfs(n + 1, S, visited, arr, N);

            S[n] = prev;
            S[n + tmp + 1] = prev;
            visited[i] = false;

        }
    }
    static {
        try {
            new baek_1469().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
