package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class baek_11399 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(people);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                sum += people[j];
            }
        }

//        System.out.println(sum);
        write.write(sum + "");
        write.flush();
    }
}
