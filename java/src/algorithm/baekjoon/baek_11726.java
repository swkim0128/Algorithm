package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_11726 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }
        else if (N == 2) {
            System.out.println(2);
            return;
        }

        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < N; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[N - 1]);
    }
}
