package algorithm.jungol;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class jungol_1828 extends Solution {
    @Override
    public void solution() throws IOException {
        int N;
        N = Integer.parseInt(read.readLine());

        Temper[] tempers = new Temper[N];

        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            tempers[i] = new Temper(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }

        Arrays.sort(tempers);

        ArrayList<Temper> arrayList = new ArrayList<>();
        arrayList.add(tempers[0]);

        for (int i = 1; i < N; i++) {
            int min = tempers[i].min;
            int max = tempers[i].max;

            if (arrayList.get(arrayList.size() - 1).max < min) {
                arrayList.add(tempers[i]);
            }
        }
        System.out.println(arrayList.size());
    }

    class Temper implements Comparable<Temper> {
        int min;
        int max;

        Temper(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public int compareTo(Temper o) {
            return (this.max - o.max);
        }
    }
}
