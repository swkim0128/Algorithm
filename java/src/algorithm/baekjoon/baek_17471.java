package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_17471 extends Solution {
    int N;
    int[] arr;
    int[][] graph;

    @Override
    public void solution() throws IOException {
        N = Integer.parseInt(read.readLine());
        arr = new int[N];
        graph = new int[N][N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            int n = Integer.parseInt(token.nextToken());

            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(token.nextToken());
                graph[i][temp - 1] = 1;
                graph[temp - 1][i] = 1;
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        int result = 999_999_999;
        for (int i = 0; i < (1 << N); i++) {
            a.clear();
            b.clear();

            if (i == 0 || i == (1 << N) - 1)
                continue;

            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    a.add(j);
                }
                else {
                    b.add(j);
                }
            }

            if (bfs(a) && bfs(b)) {
                int amountA = 0;
                int amountB = 0;

                for (int j = 0; j < a.size(); j++) {
                    amountA += arr[a.get(j)];
                }
                for (int j = 0; j < b.size(); j++) {
                    amountB += arr[b.get(j)];
                }

                if (result > Math.abs(amountA - amountB)) {
                    result = Math.abs(amountA - amountB);
                }
            }
        }

        if (result == 999_999_999) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    public boolean bfs(ArrayList<Integer> array) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        int n = array.get(0);
        int l = array.size();

        queue.offer(n);
        visited[n] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 0; i < N; i++) {
                if (i == temp)
                    continue;
                if (visited[i])
                    continue;
                if (graph[temp][i] == 0)
                    continue;

                if (array.contains(i)) {
                    count++;
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        if (count == l)
            return true;
        else
            return false;
    }
}