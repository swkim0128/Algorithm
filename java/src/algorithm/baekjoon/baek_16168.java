package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16168 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int V, E;
        int[][] arr;

        StringTokenizer token = new StringTokenizer(read.readLine());
        V = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());

        arr = new int[V][V];

        for (int i = 0; i < E; i++) {
            token = new StringTokenizer(read.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            arr[a][b] = 1;
        }
    }

    static {
        try {
            new baek_16168().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
