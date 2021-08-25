package algorithm.swexpert;

import algorithm.Main;
import algorithm.Solution;
import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.io.IOException;
import java.util.*;

public class expert_5644 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int M = Integer.parseInt(token.nextToken());
            int A = Integer.parseInt(token.nextToken());

            int[] moveOfA = new int[M];
            int[] moveOfB = new int[M];

            StringTokenizer tokenA = new StringTokenizer(read.readLine(), " ");
            StringTokenizer tokenB = new StringTokenizer(read.readLine(), " ");

            for (int i = 0; i < M; i++) {
                moveOfA[i] = Integer.parseInt(tokenA.nextToken());
                moveOfB[i] = Integer.parseInt(tokenB.nextToken());
            }

            AP[] aps = new AP[A];
            for (int i = 0; i < A; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                int c = Integer.parseInt(token.nextToken());
                int r = Integer.parseInt(token.nextToken());
                int C = Integer.parseInt(token.nextToken());
                int P = Integer.parseInt(token.nextToken());

                aps[i] = new AP(r, c, C, P);
            }

            final int MAP_SIZE = 11;
            int[][] map = new int[MAP_SIZE][MAP_SIZE];
            int[] dr = {0, -1, 0, 1, 0};
            int[] dc = {0, 0, 1, 0, -1};

            Person personA = new Person(1, 1);
            Person personB = new Person(10, 10);

            int sum = 0;

            sum += getCharge(aps, personA, personB);

            for (int i = 0; i < M; i++) {
                int nr, nc;
                personA.r += dr[moveOfA[i]];
                personA.c += dc[moveOfA[i]];

                personB.r += dr[moveOfB[i]];
                personB.c += dc[moveOfB[i]];

                sum += getCharge(aps, personA, personB);
            }

            answer[t] = sum;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }

    public int getCharge(AP[] aps, Person a, Person b) {
        int N = aps.length;

        ArrayList<AP> listA = new ArrayList<>();
        ArrayList<AP> listB = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (aps[i].getPower(a.r, a.c) != 0)
                listA.add(aps[i]);
            if (aps[i].getPower(b.r, b.c) != 0)
                listB.add(aps[i]);
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int result = 0;

        if (listA.size() == 0 && listB.size() == 0) {
            result = 0;
        }
        else if (listA.size() == 0) {
            result = listB.get(0).P;
        }
        else if (listB.size() == 0) {
            result = listA.get(0).P;
        }
        else if (listA.get(0) == listB.get(0)) {
            if (listA.size() == 1 && listB.size() == 1) {
                result = listA.get(0).P;
            }
            else if (listA.size() == 1) {
                result = listA.get(0).P + listB.get(1).P;
            }
            else if (listB.size() == 1) {
                result = listA.get(1).P + listB.get(0).P;
            }
            else {
                int tempA = listA.get(0).P + listB.get(1).P;
                int tempB = listA.get(1).P + listB.get(0).P;

                if (tempA < tempB)
                    result = tempB;
                else
                    result = tempA;
            }
        }
        else {
            result = listA.get(0).P + listB.get(0).P;
        }

        return result;
    }

    class Person {
        int r, c;

        Person(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class AP implements Comparable<AP> {
        int r, c;
        int C, P;

        AP(int r, int c, int C, int P) {
            this.r = r;
            this.c = c;
            this.C = C;
            this.P = P;
        }

        public int getPower(int r, int c) {
            int result = 0;
            if (distance(r, c))
                result = P;
            else
                result = 0;

            return result;
        }

        public boolean distance(int r, int c) {
            int dist = Math.abs(this.r - r) + Math.abs(this.c - c);

            boolean result = false;

            if (dist > C)
                result = false;
            else
                result = true;

            return result;
        }

        @Override
        public int compareTo(AP o) {
            return -(this.P - o.P);
        }
    }
}
