package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class expert_4013 extends Solution {
    final int SIZE = 8;
    final int MAGNETS = 4;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int K;

            K = Integer.parseInt(read.readLine());

            Magnet[] magnets = new Magnet[4];
            for (int i = 0; i < MAGNETS; i++) {
                StringTokenizer token = new StringTokenizer(read.readLine(), " ");
                magnets[i] = new Magnet(0, 6, 2);

                for (int j = 0; j < SIZE; j++) {
                    magnets[i].arr[j] = Integer.parseInt(token.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                int moveN, moveD;
                StringTokenizer token = new StringTokenizer(read.readLine(), " ");

                moveN = Integer.parseInt(token.nextToken());
                moveD = Integer.parseInt(token.nextToken());

                int[] orders = bfs(magnets, moveN - 1, moveD);

                for (int j = 0; j < MAGNETS; j++) {
                    magnets[j].move(orders[j]);
                }
            }

            int answer = 0;
            for (int i = 0; i < MAGNETS; i++) {
                int p = magnets[i].redP;
                if (magnets[i].arr[p] == 1)
                    answer += Math.pow(2, i);
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    int[] dn = {-1, 1};

    public int[] bfs(Magnet[] magnets, int moveN, int moveD) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAGNETS];

        queue.offer(moveN);
        visited[moveN] = true;

        int[] orders = new int[MAGNETS];
        orders[moveN] = moveD;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            int next;
            for (int i = 0; i < 2; i++) {
                next = n + dn[i];

                if (next < 0 || MAGNETS <= next)
                    continue;
                if (visited[next])
                    continue;

                if (i == 0) {
                    int rightP = magnets[next].rightP;
                    int leftP = magnets[n].leftP;

                    if (magnets[next].arr[rightP] != magnets[n].arr[leftP]) {
                        queue.offer(next);
                        visited[next] = true;
                        orders[next] = -orders[n];
                    }
                }
                else if (i == 1) {
                    int rightP = magnets[n].rightP;
                    int leftP = magnets[next].leftP;

                    if (magnets[n].arr[rightP] != magnets[next].arr[leftP]) {
                        queue.offer(next);
                        visited[next] = true;
                        orders[next] = -orders[n];
                    }
                }
            }
        }

        return orders;
    }

    class Magnet {
        int[] arr = new int[SIZE];
        int redP, leftP, rightP;

        Magnet(int redP, int leftP, int rightP) {
            this.redP = redP;
            this.leftP = leftP;
            this.rightP = rightP;
        }

        public void move(int d) {
            redP = (redP + (8 - d)) % 8;
            leftP = (leftP + (8 - d)) % 8;
            rightP = (rightP + (8 - d)) % 8;
        }
    }
}
