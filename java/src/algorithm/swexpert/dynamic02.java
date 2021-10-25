package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;

public class dynamic02 extends Solution {
    int[] memo = new int[1000];

    @Override
    public void solution() throws IOException {
        System.out.println(fibo(200));
    }

    public int fibo(int n) {
        if (n == 1) {
            return memo[1] = 2;
        }

        if (n >= 2 && memo[n] == 0) {
            if (n % 2 == 0) {
                memo[n] = fibo(n - 1) * 2 + 1;
            }
            else {
                memo[n] = fibo(n - 1) * 2;
            }
        }

        return memo[n];
    }
}
