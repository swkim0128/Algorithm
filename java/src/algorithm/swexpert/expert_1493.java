package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1493 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            int p = Integer.parseInt(token.nextToken());
            int q = Integer.parseInt(token.nextToken());

            int[] pXY = searchXY(p);
            int[] qXY = searchXY(q);

            int x = pXY[0] + qXY[0];
            int y = pXY[1] + qXY[1];

            int start = 1;
            int startSq = 1;

            for (int i = 1; i < x + y - 1; i++) {
                start += startSq;
                startSq++;
            }

            int answer = start + x - 1;
            System.out.println("#" + (t + 1) + " " + answer);
        }

    }

    public int[] searchXY(int p) {
        int start = 1;
        int startSq = 1;

        int x = 1, y = 1;

        while (true) {
            if (start <= p && p < start + startSq) {
                int temp = p - start;
                y -= temp;
                x += temp;
                break;
            }

            start += startSq;
            startSq++;
            y++;
        }

        int[] result = new int[2];
        result[0] = x;
        result[1] = y;

        return result;
    }
}
