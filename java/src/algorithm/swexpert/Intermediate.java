package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;

public class Intermediate extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int [testCase];

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(read.readLine());
            char[][] map = new char[n][n];

            for (int i = 0; i < n; i++) {
                map[i] = read.readLine().toCharArray();
            }

            int coverRange = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'X' || map[i][j] == 'H' || map[i][j] == 'G') continue;

                    switch (map[i][j]) {
                        case 'A':
                            coverRange = 1;
                            break;
                        case 'B':
                            coverRange = 2;
                            break;
                        case 'C':
                            coverRange = 3;
                            break;
                    }

                    for (int k = i - coverRange; k < i + coverRange + 1; k++) {
                        if (0 <= k && k < n) {
                            map[k][j] = 'G';
                        }
                    }
                    for (int k = j - coverRange; k < j + coverRange + 1; k++) {
                        if (0 <= k && k < n) {
                            map[i][k] = 'G';
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 'H')
                        answer[t]++;
                }
            }
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
