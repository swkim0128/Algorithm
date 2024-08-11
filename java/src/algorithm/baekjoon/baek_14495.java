package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_14495 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
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
}
