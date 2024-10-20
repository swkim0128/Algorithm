package algorithm.baekjoon;

import algorithm.Main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11399 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

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
    static {
        try {
            new baek_11399().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
