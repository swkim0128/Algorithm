package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_3052 extends Solution {
    @Override
    public void solution() throws IOException {
        final int NUM = 42;
        int[] arr = new int[NUM];

        for (int i = 0; i < 10; i++) {
            int n = scan.nextInt();
            int remainder = n % NUM;

            arr[remainder]++;
        }

        int answer = 0;
        for (int i = 0; i < NUM; i++) {
            if (arr[i] != 0)
                answer++;
        }

        System.out.println(answer);
    }
}
