package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_20164 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String N = read.readLine();

        int result = 0;
        if (N.length() <= 3) {
            result = dfs(0, 0, N);
        } else {
            for (int i = 1; i < N.length() - 1; i++) {
                int temp = dfs(N);
            }
        }
    }

    Integer dfs(int s, int e, String N) {
        if (N.length() == 1) {
            int n = Integer.parseInt(N);

            if (n % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        } else if (N.length() == 2) {
            int x = Integer.parseInt(N.substring(0, 1));
            int y = Integer.parseInt(N.substring(1));

            int cnt = 0;
            cnt = x % 2 == 0 ? cnt : cnt + 1;
            cnt = y % 2 == 0 ? cnt : cnt + 1;
            cnt += dfs(String.valueOf(s, e, x + y));
            return cnt;
        } else if (N.length() == 3){
            int x = Integer.parseInt(N.substring(0, 1));
            int y = Integer.parseInt(N.substring(1, 2));
            int z = Integer.parseInt(N.substring(2));

            int cnt = 0;
            cnt = x % 2 == 0 ? cnt : cnt + 1;
            cnt = y % 2 == 0 ? cnt : cnt + 1;
            cnt = z % 2 == 0 ? cnt : cnt + 1;
            cnt += dfs(String.valueOf(s, e, x + y + z));
            return cnt;
        } else {
            int x = Integer.parseInt(N.substring(0, s));
            int y = Integer.parseInt(N.substring(s, e));
            int z = Integer.parseInt(N.substring(e));

            int cnt = 0;
            cnt = x % 2 == 0 ? cnt : cnt + 1;
            cnt = y % 2 == 0 ? cnt : cnt + 1;
            cnt = z % 2 == 0 ? cnt : cnt + 1;
            cnt += dfs(String.valueOf(s, e, x + y + z));
            return cnt;
        }
    }

    static {
        try {
            new baek_20164().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
