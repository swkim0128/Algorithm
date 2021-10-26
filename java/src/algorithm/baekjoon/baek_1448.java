package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class baek_1448 extends Solution {
    int N;
    Integer[] arr;

    int answer = -1;
    int a = 0, b = 0, c = 0;

    @Override
    public void solution() throws IOException {
        N = Integer.parseInt(read.readLine());

        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Integer(read.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());
        combi(0, 0, 0);

        System.out.println(answer);
    }

    public void combi(int cnt, int start, int amount) {
        if (cnt == 3) {
            if (c < a + b) {
                if (answer < amount)
                    answer = amount;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if (cnt == 0) {
                c = arr[i].intValue();
            }
            else if (cnt == 1) {
                a = arr[i].intValue();
            }
            else if (cnt == 2) {
                b = arr[i].intValue();
            }

            combi(cnt + 1, ++start, amount + arr[i].intValue());
        }
    }
}
