package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_2292 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

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
}
