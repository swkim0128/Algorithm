package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baek_20117 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N;

        N = Integer.parseInt(read.readLine());
        int[] arr = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        // algo
        int all = 1 << N;
        int result = 0;
        for (int i = 0; i < all; i++) {
            List<Integer> tmpArr = new ArrayList<>();
            List<Integer> otherTmpArr = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) == 0) {
                    tmpArr.add(arr[j]);
                }
                else {
                    otherTmpArr.add(arr[j]);
                }
            }

            if (tmpArr.size() == 1)
                continue;

            Collections.sort(tmpArr);
            Collections.sort(otherTmpArr);

            int idx = tmpArr.size() / 2;
            int otherIdx = otherTmpArr.size() / 2;
            int resultTmp = 0;
            for (int j = 0; j < N; j++) {
                if (tmpArr.contains(arr[j])) {
                    resultTmp += tmpArr.get(idx);
                }
                else {
                    resultTmp += otherTmpArr.get(otherIdx);
                }
            }

            if (result < resultTmp) {
                result = resultTmp;
            }
        }

        // output
        System.out.println(result);
    }
    static {
        try {
            new baek_20117().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
