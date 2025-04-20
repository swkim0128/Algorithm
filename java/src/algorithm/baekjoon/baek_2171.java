package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2171 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int[][] arr;

        N = Integer.parseInt(read.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }

        for (int i = 0; i < N; i++) {

        }
    }

    static {
        try {
            new baek_2171().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
