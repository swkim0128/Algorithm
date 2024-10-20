package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1931 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N;

        N = Integer.parseInt(read.readLine());

        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a, b;
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());

            list.add(new Time(a, b));
        }

        Collections.sort(list);

        Time t = list.get(0);
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (t.b <= list.get(i).a) {
                t = list.get(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    class Time implements Comparable<Time> {
        int a, b;

        Time(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Time o) {
            if (this.b == o.b) {
                return this.a - o.a;
            }
            else {
                return this.b - o.b;
            }
        }
    }
    static {
        try {
            new baek_1931().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
