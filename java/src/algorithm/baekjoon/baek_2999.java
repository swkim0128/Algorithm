package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2999 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        String message = read.readLine();
        int messageLength = message.length();

        int R = 0, C = 0;
        for (int i = 1; i < messageLength + 1; i++) {
            for (int j = 1; j < messageLength + 1; j++) {
                if (i <= j && R <= i) {
                    if (i * j == messageLength) {
                        R = i;
                        C = j;
                    }
                }
            }
        }

        char[][] decodeArr = new char[R][C];
        int cnt = 0;
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                decodeArr[i][j] = message.charAt(cnt);
                cnt++;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(decodeArr[i][j]);
            }
        }

        System.out.println();
    }
    static {
        try {
            new baek_2999().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
