package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class baek_1758 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        // algo
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        // 내림차순 순서로 i 값만큼 뺀 값을 더함, 마이너스면 0
        int result = 0;
        for (int i = 0; i < N; i++) {
            int tmp = arr[i] - (i + 1 - 1);
            if (tmp <= 0) {
                break;
            }
            else {
                result += tmp;
            }
        }

        // output
        System.out.println(result);
    }
}
