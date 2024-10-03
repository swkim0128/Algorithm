package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_24523 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N;
        int[] arr;

        N = Integer.parseInt(read.readLine());
        arr = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 1 <= i <= N, i < j <= N, ai != aj
        // i 1 2 3 4 5 6
        // N 3 3 1 1 4 4

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = -1;
            for (int j = i + 1; j < N; j++) {
                if (arr[i] != arr[j]) {
                    result[i] = j + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (result[i] == -1) {
                System.out.print(result[i]);
            }
            else {
                System.out.print(result[i]);
            }
            System.out.print(" ");
        }
    }
}
