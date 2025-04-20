package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_20007 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //  집 수,  도로 수, 하루 길이, 시작위치
        int N, M, X, Y;
        int[][] arr;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());
        Y = Integer.parseInt(token.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine());
            int A, B, C;
            A = Integer.parseInt(token.nextToken());
            B = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            arr[A][B] = C;
            arr[B][A] = C;
        }

//        0 1 6
//        0 2 3
//        0 3 10
//        1 2 2
//        2 4 7
//        3 4 8
        // 0 - 2 - 4 10
        // 0 - 1 6
        // 0 - 3 10

        int cnt = 0;
        boolean[] visited = new boolean[N];

        while (true) {
            int start = Y;
            int next = -1;

            for (int i = 0; i < N; i++) {
                if (arr[start][i] == 0) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }

                if (next == -1) {
                    next = i;
                } else if (arr[start][i] < arr[start][next]) {
                    next = i;
                }
            }

            int sum = arr[start][next];
            if (sum * 2 > Y) {

            } else if (sum * 2 = Y) {

            }
            while (sum * 2 <= Y) {
                for (int i = 0; i < N; i++) {
                    if (arr[start][i] == 0) {
                        continue;
                    }
                    if (visited[i]) {
                        continue;
                    }

                    if (next == -1) {
                        next = i;
                    } else if (arr[start][i] < arr[start][next]) {
                        next = i;
                    }
                }
            }
        }

    }

    static {
        try {
            new baek_20007().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
