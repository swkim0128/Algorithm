package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class expert_1861 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answerNum = new int[testCase];
        int[] answerResult = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());
            int[][] array = new int[N][N];
            StringTokenizer token;

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    array[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int[][] resultArr = new int[N][N];
            int resultMax = 0;
            int resultNum = N * N + 1;
            int result;
            Queue<Pair> queue = new LinkedList<>();
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = 0;

                    queue.offer(new Pair(i, j));
                    result++;
                    resultArr[i][j]++;

                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();

                        int nr, nc;
                        for (int d = 0; d < 4; d++) {
                            nr = p.r + dr[d];
                            nc = p.c + dc[d];

                            if (nr < 0 || N <= nr || nc < 0 || N <= nc) continue;

                            if (array[nr][nc] - array[p.r][p.c] == 1) {
                                queue.offer(new Pair(nr, nc));
                                result++;
                                resultArr[i][j]++;
                            }
                        }
                    }

                    if (resultMax < result) {
                        resultMax = result;
                        resultNum = array[i][j];
                    }
                    else if (resultMax == result) {
                        if (resultNum > array[i][j]) {
                            resultNum = array[i][j];
                        }
                    }
                }
            }

            answerNum[t] = resultNum;
            answerResult[t] = resultMax;
        }

        for (int t = 0; t < testCase; t++) {
            write.write("#" + (t + 1) + " " + answerNum[t] + " " + answerResult[t]);
            write.newLine();
        }
        write.flush();
    }

    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
