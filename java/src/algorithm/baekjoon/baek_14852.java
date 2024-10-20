package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_14852 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

        if (N == 1) {
            System.out.println(2);
            return;
        }
        else if (N == 2) {
            System.out.println(7);
            return;
        }
        else if (N == 3) {
            System.out.println(22);
            return;
        }

        long[] f = new long[N + 1];
        f[1] = 2;
        f[2] = 7;
        f[3] = 22;

        long[] g = new long[N + 1];
        g[3] = 1;

        for (int i = 4; i < N + 1; i++) {
            // 타일이 유일한 경우의 수
            g[i] = (g[i - 1] + f[i - 3]) % 1000000007;

            // 전체 점화식
            f[i] = (f[i - 1] * 2 + f[i - 2] * 3 + g[i] * 2) % 1000000007;
        }

        System.out.println(f[N]);
//        int g_n = (f[N] * (pow - 1) + 1) % 1000000007;
//        System.out.println(g_n);
    }
    static {
        try {
            new baek_14852().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
