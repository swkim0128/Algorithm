package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2292 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());

        // 1, 6, startRange, endRange, count, answer
        final int BEE = 6;
        int count = 0;
        int startRange = 1;
        int endRange = startRange + BEE * count + 1;

        int answer = 1;
        while (true) {
            if (startRange <= N && N < endRange) {
                break;
            }

            count++;
            startRange = endRange;
            endRange += BEE * count;
            answer++;
        }

        System.out.println(answer);
    }
    static {
        try {
            new baek_2292().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
