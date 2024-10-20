package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2563 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());
        final int drawingSize = 100;
        int[][] map = new int[drawingSize][drawingSize];

        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < drawingSize; i++) {
            for (int j = 0; j < drawingSize; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
    static {
        try {
            new baek_2563().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
