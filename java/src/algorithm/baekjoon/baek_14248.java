package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_14248 extends Solution {

    @Override
    public void solution() throws IOException {
        // input
        int N = Integer.parseInt(read.readLine());

        int[] ai = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer token = new StringTokenizer(read.readLine());
        for (int i = 0; i < N; i++) {
            ai[i] = Integer.parseInt(token.nextToken());
        }

        int s = Integer.parseInt(read.readLine());
        s--;

        // algo
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int result = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();

            int nIdx = idx + ai[idx];
            int pIdx = idx - ai[idx];

            if (0 <= nIdx && nIdx < N && !visited[nIdx]) {
                queue.add(nIdx);
                visited[nIdx] = true;
                result++;
            }
            if (0 <= pIdx && pIdx < N && !visited[pIdx]) {
                queue.add(pIdx);
                visited[pIdx] = true;
                result++;
            }
        }

        // output
        result++;
        System.out.println(result);
    }
}
