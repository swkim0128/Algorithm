package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1727 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, M;
        int[] nArr, mArr;

        // input
        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        nArr = new int[N];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(token.nextToken());
        }

        mArr = new int[M];
        token = new StringTokenizer(read.readLine());
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        // 두 배열의 차이의 최소값
        // 커플은 모두 성사 X
        // 한 배열을 기준으로 선택되지 않은 최소값을 찾아 선택

        // 일단 오름차순 정렬
        Arrays.sort(nArr);
        Arrays.sort(mArr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            }
        }
    }
    static {
        try {
            new baek_1727().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
