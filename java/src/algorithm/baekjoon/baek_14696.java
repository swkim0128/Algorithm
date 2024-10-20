package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14696 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int a = Integer.parseInt(token.nextToken());

            int[] ttakjiA = new int[a];
            for (int i = 0; i < a; i++) {
                ttakjiA[i] = Integer.parseInt(token.nextToken());
            }

            token = new StringTokenizer(read.readLine(), " ");
            int b = Integer.parseInt(token.nextToken());
            int[] ttakjiB = new int[b];
            for (int i = 0; i < b; i++) {
                ttakjiB[i] = Integer.parseInt(token.nextToken());
            }

            char answer = isWinner(ttakjiA, ttakjiB);
            System.out.println(answer);
        }
    }

    public char isWinner(int[] ttakjiA, int[] ttakjiB) {
        final int TTAKJI_SIZE = 4;
        int[] aCnt = new int[TTAKJI_SIZE + 1];
        int[] bCnt = new int[TTAKJI_SIZE + 1];

        for (int i = 0; i < ttakjiA.length; i++) {
            switch (ttakjiA[i]) {
                case 4:
                    aCnt[4]++;
                    break;
                case 3:
                    aCnt[3]++;
                    break;
                case 2:
                    aCnt[2]++;
                    break;
                case 1:
                    aCnt[1]++;
                    break;
            }
        }

        for (int i = 0; i < ttakjiB.length; i++) {
            switch (ttakjiB[i]) {
                case 4:
                    bCnt[4]++;
                    break;
                case 3:
                    bCnt[3]++;
                    break;
                case 2:
                    bCnt[2]++;
                    break;
                case 1:
                    bCnt[1]++;
                    break;
            }
        }

        char result = ' ';
        for (int i = TTAKJI_SIZE; i > -1; i--) {
            if (aCnt[i] > bCnt[i]) {
                return 'A';
            }
            else if (aCnt[i] < bCnt[i]) {
                return 'B';
            }
            else {
                result = 'D';
            }
        }

        return result;
    }
    static {
        try {
            new baek_14696().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
