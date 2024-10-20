package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class baek_2667 extends Main {
    int N;
    ArrayList<Integer> answer = new ArrayList<>();
    int answerSize = 1;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        N = Integer.parseInt(read.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = read.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j])
                    continue;
                if (arr[i][j] == 0)
                    continue;
                bfs(arr, i, j);
                answerSize++;
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    boolean[][] visited;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public void bfs(int[][] arr, int r, int c) {
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(r, c));
        arr[r][c] = answerSize;
        visited[r][c] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Data d = queue.poll();

            int nr = 0, nc = 0;
            for (int i = 0; i < 4; i++) {
                nr = d.r + dr[i];
                nc = d.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (arr[nr][nc] == 0)
                    continue;
                if (visited[nr][nc])
                    continue;

                queue.offer(new Data(nr, nc));
                arr[nr][nc] = answerSize;
                count++;
                visited[nr][nc] = true;
            }
        }

        answer.add(count);
    }

    class Data {
        int r, c;

        Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_2667().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
