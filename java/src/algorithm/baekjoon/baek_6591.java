package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_6591 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N, K;

            StringTokenizer token = new StringTokenizer(read.readLine());
            N = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());

            if (N == 0 && K == 0) {
                break;
            }

            long result = 0L;
            long cnt = 1L << N;
            for (int i = 0; i < cnt; i++) {
                List<Integer> arr = new ArrayList<>();

                for (int j = 0; j < N; j++) {
                    if (arr.size() > K) {
                        break;
                    }
                    if (((1 << j) & i) == 0) {
                        arr.add(j);
                    }
                }

                if (arr.size() == K) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }

    static {
        try {
            new baek_6591().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
