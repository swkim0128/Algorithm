package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;

public class dynamic extends Solution {
    int[] memo = new int[100];

    @Override
    public void solution() throws IOException {
        System.out.println(fibo(8));
    }

    public int fibo(int n) {
        if (n == 0) {
            return memo[n] = 2;
        }
        if (n == 1)
            return memo[n] = memo[1] + 1;

        if (n >= 2 && memo[n] == 0)
            memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n];
    }
}
