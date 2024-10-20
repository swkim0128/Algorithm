package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_8958 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int testCase = Integer.parseInt(read.readLine());

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
    static {
        try {
            new baek_8958().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
