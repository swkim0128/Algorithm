package algorithm.jungol;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class jungol_2577 extends Solution {
    @Override
    public void solution() throws IOException {
        int N, d, k, c;

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        d = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        int[] count = new int[d + 1];
        int cnt = 0;

        for (int j = 0; j < k; j++) {
            int n = arr[j];

            if (count[n] == 0) {
                cnt++;
            }
            count[n]++;
        }

        if (count[c] == 0)
            cnt++;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (answer < cnt)
                answer = cnt;

            if (answer == k + 1)
                break;

            if (count[c] == 0)
                cnt--;

            int n = arr[i];
            count[n]--;
            if (count[n] == 0)
                cnt--;

            n = arr[(i + k) % N];
            if (count[n] == 0)
                cnt++;
            count[n]++;

            if (count[c] == 0)
                cnt++;
        }

        System.out.println(answer);
    }
}
