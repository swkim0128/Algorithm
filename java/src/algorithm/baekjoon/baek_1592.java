package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_1592 extends Solution {
    @Override
    public void solution() throws IOException {
        int N, M, L;
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
}
