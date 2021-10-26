package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_8320 extends Solution {
    @Override
    public void solution() throws IOException {
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
}
