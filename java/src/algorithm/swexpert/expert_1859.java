package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1859 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());
            int[] arr = new int[N];

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }

            int[] max = new int[N];

            int slope = arr[0];
            for (int i = 1; i < N; i++) {
                if (slope < arr[i]) {
                    slope = arr[i];
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    int temp = slope - arr[j];

                    if (temp < 0) continue;
                    if (max[j] < temp)
                        max[j] = temp;
                }
                slope = arr[i];
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += max[i];
            }

            System.out.println("#" + (t + 1) + " " + sum);
        }
    }
}
