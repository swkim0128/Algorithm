package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_30108 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int[] P;
        int[] A;

        N = Integer.parseInt(read.readLine());

        P = new int[N];
        A = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }
    }

    static {
        try {
            new baek_30108().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
