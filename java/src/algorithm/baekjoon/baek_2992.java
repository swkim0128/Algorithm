package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2992 extends Main {
    String X;

    boolean[] visited;
    int[] idxs;
    int result = 9999999;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        X = read.readLine();

        // algo
        // X와 구성이 같으면서 X 보다 큰 수 중 가장 작은 수를 출력
        // 수의 구성이 같다는 말은, 수를 이루고 있는 각 자리수가 같다는 뜻이다. 예를 들어, 123과 321은 수의 구성이 같다. 하지만, 123과 432는 구성이 같지 않다.
        visited = new boolean[X.length()];
        idxs = new int[X.length()];

        dfs(0);

        // X 보다 큰 수, X의 각 자리의 숫자와 동일한 수, 그 중 가장 작은 수
        // 일의 자리 ... n의 자리
        // 0 1 2 / 0 2 1 / 1 0 2 / 1 2 0 /...

        if (result == 9999999) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }
    }

    void dfs(int cnt) {
        // 종료 조건
        if (X.length() == cnt) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < X.length(); i++) {
                int idx = idxs[i];
                builder.append(X.charAt(idx));
            }

            int builderInt = Integer.parseInt(builder.toString());
            int x = Integer.parseInt(X);
            if (builderInt > x && result > builderInt) {
                result = builderInt;
            }

            return ;
        }

        for (int i = 0; i < X.length(); i++) {
            if (visited[i]) {
                continue;
            }
            // dfs
            visited[i] = true;
            idxs[cnt] = i;
            dfs(cnt + 1);

            visited[i] = false;
        }
    }

    static {
        try {
            new baek_2992().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
