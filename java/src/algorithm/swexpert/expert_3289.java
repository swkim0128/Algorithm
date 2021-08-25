package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_3289 extends Solution {
    int[] p;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            int n, m;
            n = Integer.parseInt(token.nextToken());
            m = Integer.parseInt(token.nextToken());

            p = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                p[i] = i;
            }

            char[] answer = new char[m];
            int answerSize = 0;

            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(read.readLine(), " ");

                int o, a, b;
                o = Integer.parseInt(token.nextToken());
                a = Integer.parseInt(token.nextToken());
                b = Integer.parseInt(token.nextToken());

                if (o == 0)
                    union(a, b);
                else {
                    answer[answerSize] = (char)(isUnion(a, b) + '0');
                    answerSize++;
                }
            }

            System.out.print("#" + (t + 1) + " ");
            for (int i = 0; i < answerSize; i++) {
                System.out.print(answer[i]);
            }
        }
    }

    public int findSet(int x) {
        if (x == p[x])
            return x;
        else
            return p[x] = findSet(p[x]);
    }

    public void union(int x, int y) {
        int a = findSet(x);
        int b = findSet(y);

        if (a == b)
            return;

        if (a < b)
            p[b] = a;
        else
            p[a] = b;
    }

    public int isUnion(int x, int y) {
        if (findSet(x) == findSet(y))
            return 1;
        else
            return 0;
    }
}
