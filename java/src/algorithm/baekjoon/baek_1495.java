package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.*;

public class baek_1495 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());

        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(S, 0));

        int result = -1;
        while (!queue.isEmpty()) {
            Index tmp = queue.poll();
            int i = tmp.idx;

            if (N == i) {
                if (result <= tmp.v) {
                    result = tmp.v;
                }
                continue;
            }

            int minus = tmp.v - V[i];
            int plus = tmp.v + V[i];

            if (0 <= minus) {
                queue.add(new Index(minus, i + 1));
            }
            if (plus <= M) {
                queue.add(new Index(plus, i + 1));
            }
        }

        // output
        System.out.println(result);
    }

    private class Index {
        int v;
        int idx;

        Index(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}
