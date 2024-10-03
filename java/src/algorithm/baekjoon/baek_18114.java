package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class baek_18114 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N;
        long C;
        long[] arr;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        C = Long.parseLong(token.nextToken());

        arr = new long[N];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(token.nextToken());
        }

        // algo
        int isTrue = 0;
        int count = 1 << N;
        for (int i = 0; i < count; i++) {

            ArrayList<Integer> idxs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    idxs.add(j);
                }
            }

            if (idxs.size() > 3) continue;

            long sum = 0;
            for (Integer idx : idxs) {
                sum += arr[idx];
            }

            if (sum == C) {
                isTrue = 1;
                break;
            }
        }

        System.out.println(isTrue);
    }
}
