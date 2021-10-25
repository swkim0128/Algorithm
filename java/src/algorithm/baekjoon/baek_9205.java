package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.*;

public class baek_9205 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            int[][] arr = new int[N + 2][N + 2];
            ArrayList<Point> list = new ArrayList<>();

            for (int i = 0; i < N + 2; i++) {
                int x, y;
                StringTokenizer token = new StringTokenizer(read.readLine(), " ");

                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());

                list.add(new Point(x, y));
            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    arr[i][j] = list.get(i).getDistance(list.get(j).x, list.get(j).y);
                }
            }

            String answer = fluid(arr);
            System.out.println(answer);
        }
    }

    public String fluid(int[][] arr) {
        int N = arr.length;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (k == i)
                    continue;
                for (int j = 0; j < N; j++) {
                    if (k == j || i == j)
                        continue;

                    arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(0);
        visited[0] = true;

        boolean isHappy = true;
        int idx = 0;
        while (!queue.isEmpty()) {
            idx = queue.poll();

            if (idx == N - 1)
                break;

            for (int i = 0; i < N; i++) {
                if (idx == i)
                    continue;
                if (visited[i])
                    continue;
                if (arr[idx][i] > 1000)
                    continue;

                queue.offer(i);
                visited[i] = true;
            }
        }

        if (idx == N - 1)
            isHappy = true;
        else
            isHappy = false;

        if (isHappy) {
            return "happy";
        }
        else {
            return "sad";
        }
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(int x, int y) {
            return Math.abs(this.x - x) + Math.abs(this.y - y);
        }
    }
}
