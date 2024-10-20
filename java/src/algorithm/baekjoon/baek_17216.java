package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_17216 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N = Integer.parseInt(read.readLine());
        StringTokenizer token = new StringTokenizer(read.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 수열 A가 주어졌을 때, 그 수열의 감소 부분 수열 중에서 합이 가장 큰 것
        // 순열?
        // 순열 인덱스 배열 - 감소하는지
        // 최대값
        int result = 0;
        for (int i = (1 << N) - 1; i >= 0; i--) {

            // index 조합 추출
            List<Integer> indexs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    indexs.add(j);
                }
            }

            if (isDecre(arr, indexs)) {
                int tmp = 0;
                for (Integer idx : indexs) {
                    tmp += arr[idx];
                }

                if (result < tmp) {
                    result = tmp;
                }
            }
        }

        // output
        System.out.println(result);
    }

    public static boolean isDecre(int[] arr, List<Integer> indexs) {
        for (int i = 1; i < indexs.size(); i++) {
            if (arr[indexs.get(i - 1)] <= arr[indexs.get(i)]) {
                return false;
            }
        }
        return true;
    }
    static {
        try {
            new baek_17216().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
