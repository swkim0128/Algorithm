package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_2839 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = scan.nextInt();

        int answer = 0;
        if (N % 5 == 0) {
            answer += N / 5;
        }
        else if (N % 5 == 1) {
            answer += N / 5 - 1;
            answer += N % 5 + 1;
        }
        else if (N % 5 == 2) {
            if (N / 5 - 2 > 0) {
                answer += N / 5 - 2;
                answer += 4;
            }
            else {
                if (N % 3 == 0)
                    answer += 4;
                else
                    answer = -1;
            }
        }
        else if (N % 5 == 3) {
            answer += N / 5;
            answer += 1;
        }
        else if (N % 5 == 4) {
            if (N / 5 - 1 > 0) {
                answer += N / 5 - 1;
                answer += 3;
            }
            else {
                if (N % 3 == 0)
                    answer += 3;
                else
                    answer = -1;
            }
        }

        System.out.println(answer);
    }
}
