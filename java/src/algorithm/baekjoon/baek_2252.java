package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2252 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, M;

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        LinkedList[] arr = new LinkedList[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            int a, b;

            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());

            arr[a].add(b);
            indegree[b]++;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer.add(now);

            for (Object i : arr[now]) {
                indegree[(int) i]--;

                if (indegree[(int) i] == 0)
                    queue.offer((Integer) i);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
    static {
        try {
            new baek_2252().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
