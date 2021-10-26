package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_7465 extends Solution {
    int[] p;

    @Override
    public void solution() throws IOException {
        int testCas  = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCas; t++) {
            int N, M;
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            p = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                p[i] = i;
            }

            for (int i = 0; i < M; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                union(x, y);
            }

            int[] parent = new int[N + 1];
            int parentSize = 0;
            loop:for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    if (parent[j] == findSet(i)) continue loop;
                }
                parentSize++;
                parent[parentSize] = findSet(i);
            }

            System.out.println("#" + (t + 1) + " " + parentSize);
        }
    }

    public int findSet(int x) {
        if (x == p[x])
            return x;
        else
            return p[x] = findSet(p[x]);
    }

    public void union(int x, int y) {
        if (findSet(x) == findSet(y)) {
            return ;
        }

        p[findSet(y)] = findSet(x);
    }
}
