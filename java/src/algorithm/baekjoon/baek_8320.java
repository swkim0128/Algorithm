package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_8320 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            sum += getCnt(i);
        }

        System.out.println(sum);
    }

    public int getCnt(int n) {
        if (n == 1)
            return 1;

        int result = 0;
        for (int i = 1; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                for (int j = i; j < n + 1; j++) {
                    if (i * j == n) {
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }
    static {
        try {
            new baek_8320().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
