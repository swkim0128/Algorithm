package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_3307 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }

            int[] lis = new int[N];
            lis[0] = arr[0];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (lis[idx] < arr[i]) {
                    lis[++idx] = arr[i];
                }
                else {
                    int ii = lower_bound(lis, idx, arr[i]);
                    lis[ii] = arr[i];
                }
            }

            System.out.println("#" + (t + 1) + " " + lis.length);
        }
    }

    public int lower_bound(int[] lis, int end, int n) {
        int start = 0;

        while (start < end) {
            int mid = (start + end) / 2;

            if (lis[mid] >= n) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return end;
    }
}
