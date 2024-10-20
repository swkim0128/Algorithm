package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_17291 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());

        // algo
        // N = 1 1  , 3년 후 -1
        // N = 2 1 -> 2, 4년 후 -1
        // N = 3 2 -> 4, 3년 후 -2
        // N = 4 4 -> 8, 4년 후 -4
        // N = 5 7 -> 14 3년 후 -7
        // N = 6 14 -> 28 -3
        // n = 25 -> 50
        int[][] arr = new int[50][2];

        // 0 => n년 1월 분열수
        // 1 => n년 말월 죽음수
        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[1 + 3][1] = 1;
        for (int i = 2; i < 21; i++) {
            int tmp = arr[i - 1][0] - arr[i - 1][1];
            arr[i][0] = tmp * 2;
            if (i % 2 == 0) {
                arr[i + 4][1] += tmp;
            }
            else {
                arr[i + 3][1] += tmp;
            }
        }

        // output
        int result = arr[N][0] - arr[N][1];
        System.out.println(result);
    }
    static {
        try {
            new baek_17291().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
