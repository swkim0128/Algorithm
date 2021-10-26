package algorithm.baekjoon;

import algorithm.Solution;

import javax.management.StandardEmitterMBean;
import java.io.IOException;
import java.util.StringTokenizer;

public class baek_2798 extends Solution {
    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        int N, M;
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine(), " ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int[] numbers = new int[N];
        for (int i = N - 1; i >= N - 3; i--) {
            numbers[i] = 1;
        }

        int answer = 0;
        do {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (numbers[i] == 1) {
                    sum += arr[i];
                }
                if (sum > M) {
                    sum = 0;
                    break;
                }
            }

            if (answer < sum)
                answer = sum;
        } while (nb(numbers));

        System.out.println(answer);
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
