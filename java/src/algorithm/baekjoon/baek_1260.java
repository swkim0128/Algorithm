package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1260 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N, M, V;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        V = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            arr[r][c] = 1;
            arr[c][r] = 1;
        }

        dfs(arr, visited, V);

        System.out.println();
        for (int i = 0; i < N + 1; i++) {
            visited[i] = false;
        }

        bfs(arr, visited, V);
    }

    public void dfs(int[][] arr, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < arr.length; i++) {
            if (v == i) continue;
            if (arr[v][i] == 0) continue;
            if (visited[i]) continue;

            dfs(arr, visited, i);
        }
    }

    public void bfs(int[][] arr, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            System.out.print(r + " ");

            for (int i = 0; i < arr.length; i++) {
                if (r == i) continue;
                if (arr[r][i] == 0) continue;
                if (visited[i]) continue;

                queue.offer(i);
                visited[i] = true;
            }
        }
    }
    static {
        try {
            new baek_1260().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
