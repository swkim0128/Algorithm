package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_14400 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N;
        int[] xArr;
        int[] yArr;

        // input
        N = Integer.parseInt(read.readLine().trim());
        xArr = new int[N];
        yArr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            xArr[i] = Integer.parseInt(token.nextToken());
            yArr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int idx = N / 2;
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.abs(xArr[i] - xArr[idx]);
            result += Math.abs(yArr[i] - yArr[idx]);
        }

        // output
        System.out.println(result);
    }
    static {
        try {
            new baek_14400().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
