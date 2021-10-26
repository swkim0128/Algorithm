package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2623 extends Solution {
    @Override
    public void solution() throws IOException {
        int N, M;

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");

            int m = Integer.parseInt(token.nextToken());
            int a = Integer.parseInt(token.nextToken());
            int b;
            for (int j = 1; j < m; j++) {
                b = Integer.parseInt(token.nextToken());
                lists[a].add(b);

                indegree[b]++;
                a = b;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int a = queue.poll();
            answer.add(a);

            for (int b : lists[a]) {
                indegree[b]--;

                if (indegree[b] == 0) {
                    queue.offer(b);
                }
            }
        }

        if (answer.size() != N) {
            System.out.println(0);
        }
        else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}
