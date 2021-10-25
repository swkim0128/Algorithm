package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_8958 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            String quiz = read.readLine();

            int cnt = 0;
            int[] score = new int[quiz.length()];
            for (int i = 0; i < quiz.length(); i++) {
                if (quiz.charAt(i) == 'O') {
                    cnt++;
                    score[i] = cnt;
                }
                else {
                    cnt = 0;
                    score[i] = cnt;
                }
            }

            int answer = 0;
            for (int i = 0; i < quiz.length(); i++) {
                answer += score[i];
            }

            System.out.println(answer);
        }
    }
}
