package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_3052 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        final int NUM = 42;
        Scanner scan = new Scanner(System.in);
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
    static {
        try {
            new baek_3052().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
