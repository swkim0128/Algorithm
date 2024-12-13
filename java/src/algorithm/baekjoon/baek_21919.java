package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_21919 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(read.readLine());
        int[] A = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        boolean[] isSosuArr = new boolean[1000001];
        List<Integer> sosu = new ArrayList<>();
        for (int i = 2; i < 1000000; i++) {
            boolean isSosu = true;
            for (Integer s : sosu) {
                if (i % s == 0) {
                    isSosu = false;
                    break;
                }
            }

            if (isSosu) {
                sosu.add(i);
                isSosuArr[i] = true;
            }
        }

        int result = 1;
        for (int i = 0; i < N; i++) {
            if (isSosuArr[A[i]]) {
                result *= A[i];
            }
        }

        System.out.println(result);
    }

    static {
        try {
            new baek_21919().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
