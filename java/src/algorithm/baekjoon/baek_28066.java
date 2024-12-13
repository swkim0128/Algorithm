package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_28066 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N, K;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        // 첫 번째 청설모부터 시계 방향으로 K마리의 청설모가 선택된다.
        // 첫 번째 청설모를 제외한 2,\cdots, K번째 청설모가 번호가 증가하는 순서대로 제거되고 첫 번째 청설모만 살아남는다.
        // 제거된 후 남아있는 청설모가 2마리 이상일 경우 첫 번째 청설모의 오른쪽 청설모가 첫 번째 청설모가 되고, 제거하는 과정을 다시 진행한다

        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            idxs.add(i);
        }

        int start = 0;

        while (idxs.size() > K) {
            // start - start + K - 1
            for (int i = 1; i < K; i++) {
                if (start + 1 >= idxs.size()) {
                    idxs.remove(0);
                }
                else {
                    idxs.remove(start + 1);
                }
            }

            if (start + 1 > idxs.size()) {
                start = 0;
            }
            else {
                start = start + 1;
            }
        }

        System.out.println(idxs.get(start) + 1);
    }

    static {
        try {
            new baek_28066().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
