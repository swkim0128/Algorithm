package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class expert_1974 extends Solution {
    @Override
    public void solution() throws IOException {
        final int SUDOKU_SIZE = 9;
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token;
            int[][] sudoku = new int[SUDOKU_SIZE][SUDOKU_SIZE];

            for (int i = 0; i < SUDOKU_SIZE; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    sudoku[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[] sudokuCount = new int[SUDOKU_SIZE + 1];

            int answer = 1;
            loop:for (int n = 0; n < SUDOKU_SIZE; n++) {
                for (int i = 0; i < SUDOKU_SIZE; i++) {
                    sudokuCount[sudoku[i][n]]++;
                    if (sudokuCount[sudoku[i][n]] > 1) {
                        answer = 0;
                        System.out.println(answer);
                        break loop;
                    }
                }
                Arrays.fill(sudokuCount, 0);

                for (int j = 0; j < SUDOKU_SIZE; j++) {
                    sudokuCount[sudoku[n][j]]++;
                    if (sudokuCount[sudoku[n][j]] > 1) {
                        answer = 0;
                        System.out.println(answer);
                        break loop;
                    }
                }
                Arrays.fill(sudokuCount, 0);

            }

            if (answer == 0) continue;

            loop:for (int n = 0; n < SUDOKU_SIZE / 3; n++) {
                int squreRowIndex = n * 3;
                for (int k = 0; k < SUDOKU_SIZE / 3; k++) {
                    int squreColumnIndex = k * 3;

                    for (int i = 0; i < SUDOKU_SIZE / 3; i++) {
                        for (int j = 0; j < SUDOKU_SIZE / 3; j++) {
                            sudokuCount[sudoku[squreRowIndex + i][squreColumnIndex + j]]++;

                            if (sudokuCount[sudoku[squreRowIndex + i][squreColumnIndex + j]] > 1) {
                                answer = 0;
                                System.out.println(answer);
                                break loop;
                            }
                        }
                    }
                    Arrays.fill(sudokuCount, 0);
                }
            }

            if (answer == 1) {
                System.out.println(answer);
            }
        }
    }
}
