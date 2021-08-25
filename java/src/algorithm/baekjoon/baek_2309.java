package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;

public class baek_2309 extends Solution {
    @Override
    public void solution() throws IOException {
        final int SIZE = 9;
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = scan.nextInt();
        }

        visited = new int[SIZE - 2];
        answer = new int[SIZE - 2];

        Arrays.sort(arr);
        combi(arr, 0, 0, 0);

        for (int i = 0; i < SIZE - 2; i++) {
            System.out.println(arr[answer[i]]);
        }
    }

    int[] visited;
    int[] answer;

    public void combi(int[] arr, int cnt, int start, int amount) {
        if (cnt == 7) {
            if (amount == 100) {
                for (int i = 0; i < 7; i++) {
                    answer[i] = visited[i];
                }
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[cnt] = i;
            combi(arr, cnt + 1, ++start, amount + arr[i]);
        }
    }
}
