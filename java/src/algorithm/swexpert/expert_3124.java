package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class expert_3124 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int V, E;
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            V = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());

            int[] p = new int[V + 1];
            for (int i = 1; i < V + 1; i++) {
                p[i] = i;
            }

            ArrayList<Data> list = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                token = new StringTokenizer(read.readLine(), " ");

                int A, B, C;
                A = Integer.parseInt(token.nextToken());
                B = Integer.parseInt(token.nextToken());
                C = Integer.parseInt(token.nextToken());

                list.add(new Data(A, B, C));
            }

            Collections.sort(list);

            Data d;
            long answer = 0;
            for (int i = 0; i < list.size(); i++) {
                d = list.get(i);

                if (findSet(p, d.a) != findSet(p, d.b)) {
                    union(p, d.a, d.b);
                    answer += d.cost;
                }
            }

            System.out.println("#" + (t + 1) + " " + Math.abs(answer));
        }
    }

    public int findSet(int[] p, int x) {
        if (p[x] != x)
            p[x] = findSet(p, p[x]);
        return p[x];
    }

    public void union(int[] p, int x, int y) {
        x = findSet(p, x);
        y = findSet(p, y);

        if (x > y) {
            p[x] = y;
        }
        else
            p[y] = x;
    }

    class Data implements Comparable<Data> {
        int a, b;
        int cost;

        Data(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data o) {
            return this.cost - o.cost;
        }
    }
}
