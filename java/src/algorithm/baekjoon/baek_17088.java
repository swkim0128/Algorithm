package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_17088 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N = Integer.parseInt(read.readLine());

        int[] B = new int[N];
        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 등차 수열 차 배열
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            arr.add(Math.abs(B[i] - B[i - 1]));
        }

        // 차이가 1 줄면 앞에 값이 + 1
        // 차이가 2 줄면 앞에 값 + 1, 뒤에 값 - 1
        int cnt = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            // 다음 값이 더 크면 +
            // 다음 값이 더 작으면 -
            int cur = arr.get(i);
            int next = arr.get(i + 1);

            if (cur == next) {
                continue;
            }
            if (Math.abs(cur - next) > 4) {
                cnt = -1;
                break;
            }
            else if (Math.abs(cur - next) == 4) {
                cnt += 2;
                arr.set(i, cur + 2);
                arr.set(i + 1, next - 1);
            }
            else if (Math.abs(cur - next) == 3) {
                cnt += 1;
                arr.set(i, cur + 1);
                arr.set(i + 1, next - 1);
            }
            else if (Math.abs(cur - next) == 2) {
                cnt += 1;
                arr.set(i, cur + 1);
                arr.set(i + 1, next - 1);
            }
            else if (Math.abs(cur - next) == 1) {
                cnt++;
            }
        }

        System.out.println(arr);
    }

    static {
        try {
            new baek_17088().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
