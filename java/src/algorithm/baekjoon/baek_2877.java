package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baek_2877 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int K;

        K = Integer.parseInt(read.readLine());

        // 좋아하는 수 중에 K번째 작은 수를 구해 출력하는 프로그램

        // 4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777

        // 4, 7
        // 44, 47, 74, 77 - 0 <= < 2
        // 444, 447, 474, 477, 744, 747, 774, 777 - 2 <= < 6
        // 4444, 4447, 4474, 4477, 4744, 4747, 4774, 4777 - 6 <= 14

        // 0, 1,
        // 2, 3, 4, 5 - 2 * 1, 2
        // 6, 7, 8, 9, 10, 11, 12, 13 4 * 1, 2
        // 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 8 * 1, 2

        // K - 1 -> K

        // K = (K - 2 * 2 n * 1, 2)

        List<String> arr = new ArrayList<>();
        arr.add("4");
        arr.add("7");

        if (K == 1) {
            System.out.println(arr.get(0));
        } else if (K == 2) {
            System.out.println(arr.get(1));
        } else {
            int p = 2;
            int cnt = 0;
            int plusMinus = 0;
            boolean isFirst = true;

            for (int i = 2; i < K; i++) {
                if (p == cnt) {
                    if (!isFirst) {
                        arr = arr.subList(p, arr.size());
                        plusMinus = p;
                        p = p * 2;
                    }
                    cnt = 0;
                    isFirst = !isFirst;
                }

                int tmp = isFirst ? i - p : i - p * 2;
                tmp -= plusMinus;

                StringBuilder stringBuilder = new StringBuilder();
                if (isFirst) {
                    stringBuilder.append("4");
                } else {
                    stringBuilder.append("7");
                }
                stringBuilder.append(arr.get(tmp));
                arr.add(stringBuilder.toString());

                cnt++;
            }
        }

        System.out.println(arr.get(arr.size() - 1));
    }

    static {
        try {
            new baek_2877().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
