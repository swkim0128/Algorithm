package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2477 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int K = Integer.parseInt(read.readLine());

        final int CNT = 6;
        final int DIRECT_SIZE = 4;

        int[][] move = new int[CNT][2];

        StringTokenizer token;
        for (int i = 0; i < CNT; i++) {
            token = new StringTokenizer(read.readLine(), " ");

            int d = Integer.parseInt(token.nextToken());
            int amount = Integer.parseInt(token.nextToken());

            move[i][0] = d;
            move[i][1] = amount;
        }

        int result = move[0][1] * move[5][1] + move[2][1] * move[3][1];

        if (move[0][0] == move[4][0] && move[1][0] == move[5][0]) {
            result = move[2][1] * move[3][1] - move[0][1] * move[5][1];
        }
        else if (move[1][0] == move[3][0] && move[2][0] == move[4][0]) {
            result = move[0][1] * move[5][1] - move[2][1] * move[3][1];
        }

        System.out.println(result * K);
    }
    static {
        try {
            new baek_2477().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
