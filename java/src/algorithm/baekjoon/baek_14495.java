package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_14495 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());

        // algo
        int size = 117;
        long[] arr = new long[size];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < size; i++) {
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        // output
        System.out.println(arr[N]);
    }
    static {
        try {
            new baek_14495().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
