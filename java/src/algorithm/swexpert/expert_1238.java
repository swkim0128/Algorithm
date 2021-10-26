package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class expert_1238 extends Solution {
    final int PEOPLE = 101;
    LinkedList<Integer>[] graph = new LinkedList[PEOPLE];

    @Override
    public void solution() throws IOException {
        int[] answer = new int[10];

        for (int t = 0; t < 10; t++) {
            int N, S;
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            S = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(read.readLine(), " ");

            for (int i = 0; i < PEOPLE; i++) {
                graph[i] = new LinkedList<>();
            }
            visited = new boolean[PEOPLE];

            for (int i = 0; i < N / 2; i++){
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                graph[x].add(y);
            }

            answer[t] = bfs(S);
        }

        for (int t = 0; t < 10; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }

    boolean[] visited;

    public int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] tempV = new int[queue.size()];

            result = 0;
            for (int i = 0; i < tempV.length; i++) {
                tempV[i] = queue.poll();
                if (result < tempV[i])
                    result = tempV[i];
            }

            for (int i = 0; i < tempV.length; i++) {
                for (int j = 0; j < graph[tempV[i]].size(); j++) {
                    int nV = graph[tempV[i]].get(j);

                    if (visited[nV]) continue;

                    queue.offer(nV);
                    visited[nV] = true;
                }
            }
        }

        return result;
    }
}
