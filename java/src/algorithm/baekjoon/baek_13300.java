package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.StringTokenizer;

public class baek_13300 extends Solution {
    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        int N, K;

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        final int GRADE = 7;
        final int GENDER = 2;
        int[][] studnets = new int[GRADE][GENDER];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");

            int S = Integer.parseInt(token.nextToken());
            int Y = Integer.parseInt(token.nextToken());

            studnets[Y][S]++;
        }

        int answer = 0;
        for (int i = 1; i < GRADE; i++) {
            for (int j = 0; j < GENDER; j++) {
                answer += studnets[i][j] / K;

                if (studnets[i][j] % K != 0)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
