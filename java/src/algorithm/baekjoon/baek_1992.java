package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_1992 extends Solution {
    int[][] arr;
    char[] answer;
    int answerSize = 0;

    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());
        arr = new int[N][N];
        answer = new char[N * N];

        String str;
        for (int i = 0; i < N; i++) {
            str = read.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);

        for (int i = 0; i < answerSize; i++) {
            System.out.print(answer[i]);
        }
        System.out.println();
    }

    public void quadTree(int r, int c, int size) {
        if (size == 1) {
            if (arr[r][c] == 0) {
                answer[answerSize] = '0';
                answerSize++;
            }
            else {
                answer[answerSize] = '1';
                answerSize++;
            }

            return;
        }

        int sum = 0;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == size * size) {
            answer[answerSize] = '1';
            answerSize++;
            return;
        }
        if (sum == 0) {
            answer[answerSize] = '0';
            answerSize++;
            return;
        }

        int half = size / 2;

        answer[answerSize] = '(';
        answerSize++;

        quadTree(r, c, half);
        quadTree(r, c + half, half);
        quadTree(r + half, c, half);
        quadTree(r + half, c + half, half);

        answer[answerSize] = ')';
        answerSize++;
    }
}
