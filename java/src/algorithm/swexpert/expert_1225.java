package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1225 extends Solution {
    @Override
    public void solution() throws IOException {

        for (int t = 0; t < 10; t++) {
            int testCase = Integer.parseInt(read.readLine());

            final int pwLength = 8;
            int[] pw = new int[pwLength];

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            for (int i = 0; i < pwLength; i++) {
                pw[i] = Integer.parseInt(token.nextToken());
            }

            int front = 0;
            int rear = 7;
            int count = 0;
            while (true) {
                count++;
                pw[front] -= count;

                if (pw[front] <= 0) {
                    pw[front] = 0;
                    front = (front + 1) % pwLength;
                    rear = (rear + 1) % pwLength;
                    break;
                }

                front = (front + 1) % pwLength;
                rear = (rear + 1) % pwLength;
                count %= 5;
            }

            System.out.print("#" + testCase + " ");
            for (int i = 0; i < pwLength; i++) {
                System.out.print(pw[(front + i) % pwLength] + " ");
            }
            System.out.println();
        }

    }
}
