package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1592 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, M, L;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());

        int[] people = new int[N];
        int startN = 0;
        int count = 0;

        while (true) {
            people[startN]++;

            if (people[startN] == M) break;
            count++;

            if (people[startN] % 2 == 1) {
                startN = (startN + L) % N;
            }
            else {
                startN = (startN + N - L) % N;
            }
        }

        System.out.println(count);
    }
    static {
        try {
            new baek_1592().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
