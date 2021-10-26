package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_9229 extends Solution {
    int N;
    int M;
    int[] a;

    int[] res;
    int max = 0;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(read.readLine(), " ");
            a = new int[N];
            res = new int[2];

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(token.nextToken());
            }

            max = -1;
            combi(0, 0);

            answer[t] = max == -1 ? -1 : max;
        }

        for (int i = 0; i < testCase; i++) {
            System.out.println("#" + (i + 1) + " " + answer[i]);
        }
    }

    public void combi(int cnt, int start) {
        if (cnt == 2) {
            int sum = 0;

            for (int i = 0; i < 2; i++){
                sum += a[res[i]];
            }

            if (sum > M)
                return ;
            if (max < sum)
                max = sum;

            return ;
        }

        for (int i = start; i < N; i++) {
            res[cnt] = i;
            combi(cnt + 1, ++start);
        }
    }
}
