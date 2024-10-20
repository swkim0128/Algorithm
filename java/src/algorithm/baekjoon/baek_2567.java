package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2567 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

        StringTokenizer token;
        int[] row = new int[N];
        int[] column = new int[N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            row[i] = Integer.parseInt(token.nextToken());
            column[i] = Integer.parseInt(token.nextToken());
        }

        final int ARR_SIZE = 100;
        int[][] arr = new int[ARR_SIZE][ARR_SIZE];

        for (int n = 0; n < N; n++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    arr[row[n] + i][column[n] + j] = 1;
                }
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int answer = 0;
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                if (arr[i][j] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 0 || ARR_SIZE <= nr || nc < 0 || ARR_SIZE <= nc) {
                        answer++;
                        continue;
                    }

                    if (arr[nr][nc] == 0)
                        answer++;
                }
            }
        }

        System.out.println(answer);
    }
    static {
        try {
            new baek_2567().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
