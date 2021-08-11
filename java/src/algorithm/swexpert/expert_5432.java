package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.Stack;

public class expert_5432 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            char[] pipe = read.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();

            int temp;
            int unCloseBlank = 0;
            int sum = 0;
            for (int i = 0; i < pipe.length; i++) {
                switch (pipe[i]) {
                    case ')':
                        unCloseBlank--;
                        temp = stack.pop();

                        if (i - temp == 1) {
                            sum += unCloseBlank;
                        }
                        else {
                            sum++;
                        }
                        break;
                    case '(':
                        stack.push(i);
                        unCloseBlank++;
                        break;
                }
            }

            answer[t] = sum;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
