package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek_16938 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());
        int X = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        Arrays.sort(A);

        int cnt = 1 << N;

        int result = 0;
        for (int i = 0; i < cnt; i++) {
            List<Integer> idxs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0) {
                    idxs.add(j);
                }
            }

            if (idxs.size() < 2) {
                continue;
            }

            int min = A[idxs.get(0)];
            int max = A[idxs.get(idxs.size() - 1)];
            int sum = 0;
            for (Integer idx : idxs) {
                sum += A[idx];
            }

            if (max - min < X) {
                continue;
            }
            if (sum < L || R < sum) {
                continue;
            }

            result++;
        }

        System.out.println(result);
    }

    static {
        try {
            new baek_16938().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
