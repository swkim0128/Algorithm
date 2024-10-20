package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_2839 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
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
    static {
        try {
            new baek_2839().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
