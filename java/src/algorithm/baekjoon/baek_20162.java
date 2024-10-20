package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_20162 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());

        int[] avg = new int[N];
        for (int i = 0; i < N; i++) {
            avg[i] = Integer.parseInt(read.readLine());
        }

        // algo
        int max = 0;
        int tmp = 0;

        for (int i = 0; i < N; i++) {
            if (tmp < avg[i]) {
                tmp = avg[i];
                max += avg[i];
            }
        }

        // output
        System.out.println(max);
    }
    static {
        try {
            new baek_20162().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
