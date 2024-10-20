package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_5671 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int[] nArr = new int[4];
        int[] mArr = new int[4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            int N = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(token.nextToken());

            nArr[i] = N;
            mArr[i] = M;
        }

        // algo
        /*
        87 104: 87, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 102, 103, 104
        989 1022:
        22 25
        1234 1234
         */

        // 5001개 배열 선언
        // 각 자리 숫자가 반복인 경우 false 아닌 경우 true
        int SIZE = 5001;
        int[] arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            if (is(i)) {
                arr[i] = 1;
            }
        }

        // output
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = nArr[i]; j <= mArr[i]; j++) {
                sum += arr[j];
            }
            System.out.println(sum);
        }
    }

    public boolean is(int i) {
        int ten = 10;
        int[] pCnt = new int[ten];

        while (i / 10 != 0) {
            int tmp = i % 10;
            i = i / 10;
            pCnt[tmp]++;

            if (pCnt[tmp] > 1) {
                return false;
            }
        }

        int tmp = i % 10;
        pCnt[tmp]++;
        return pCnt[tmp] <= 1;
    }
    static {
        try {
            new baek_5671().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
