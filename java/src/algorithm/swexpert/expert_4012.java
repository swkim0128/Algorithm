package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_4012 extends Solution {
    int N;

    int result = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            result = Integer.MAX_VALUE;
            N = Integer.parseInt(read.readLine());

            int[][] map = new int[N][N];

            StringTokenizer token;
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[] S = new int[N];
            for (int i = N - 1; i >= N / 2; i--) {
                S[i] = 1;
            }

            int[] ijA = new int[N / 2];

            int[] ijB = new int[N / 2];
            do {
                int indexA = 0;
                int indexB = 0;

                for (int i = 0; i < N; i++) {
                    if (S[i] == 1) {
                        ijA[indexA] = i;
                        indexA++;
                    }
                    else {
                        ijB[indexB] = i;
                        indexB++;
                    }
                }
                int sumA = 0;
                int sumB = 0;

                for (int i = 0; i < N / 2; i++) {
                    for (int j = i + 1; j < N / 2; j++) {
                        sumA += map[ijA[i]][ijA[j]] + map[ijA[j]][ijA[i]];
                        sumB += map[ijB[i]][ijB[j]] + map[ijB[j]][ijB[i]];
                    }
                }

                int temp = Math.abs(sumA - sumB);
                if (result > temp) {
                    result = temp;
                }
            } while (nb(S));

            answer[t] = result;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }

    public boolean nb(int[] numbers) {
        int N = numbers.length;

        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i])
            i--;

        if (i == 0)
            return false;

        int j = N - 1;
        while (numbers[i - 1] >= numbers[j])
            j--;

        swap(numbers, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(numbers, i, k);
            i++;
            k--;
        }

        return true;
    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
