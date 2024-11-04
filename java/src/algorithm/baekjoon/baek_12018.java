package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_12018 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        int N, M;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        List<List<Integer>> P = new ArrayList<>();
        List<Integer> L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            int p, l;
            // 과목 신청한 인원
            p = Integer.parseInt(token.nextToken());
            // 수강인원
            L.add(Integer.parseInt(token.nextToken()));

            token = new StringTokenizer(read.readLine());
            P.add(new ArrayList<>());
            for (int j = 0; j < p; j++) {
                P.get(i).add(Integer.parseInt(token.nextToken()));
            }
        }

        // 주어진 마일리지로 들을 수 있는 최대 과목 수
        // algo
        List<Integer> minArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            // 내림차순 정렬
            P.get(i).sort((o1, o2) -> o2 - o1);

            // Li번 째
            int idx = L.get(i) - 1;

            // 수강인원 수보다 신청인원이 적은 경우 마일리지 1 로도 신청이 가능
            if (idx + 1 > P.get(i).size()) {
                minArr.add(1);
            }
            else {
                int tmp = P.get(i).get(idx);
                minArr.add(tmp);
            }
        }

        minArr.sort(((o1, o2) -> o1 - o2));
        int result = 0;
        int sum = 0;
        for (Integer tmp : minArr) {
            sum += tmp;
            if (sum <= M) {
                result++;
            }
        }

        // output
        System.out.println(result);
    }

    static {
        try {
            new baek_12018().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
