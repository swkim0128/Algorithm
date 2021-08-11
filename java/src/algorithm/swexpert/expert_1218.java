package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.Stack;

public class expert_1218 extends Solution {
    @Override
    public void solution() throws IOException {

        boolean[] answer = new boolean[10];
        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(read.readLine());
            char[] bracket = read.readLine().toCharArray();

            Stack stack = new Stack(N);

            boolean isNotCompleted = false;
            char temp;
            for (int i = 0; i < bracket.length; i++) {
                switch (bracket[i]) {
                    case '>':
                        temp = stack.pop();
                        if (temp != '<') {
                            isNotCompleted = true;
                        }
                        break;
                    case ']':
                        temp = stack.pop();
                        if (temp != '[') {
                            isNotCompleted = true;
                        }
                        break;
                    case '}':
                        temp = stack.pop();
                        if (temp != '{') {
                            isNotCompleted = true;
                        }
                        break;
                    case ')':
                        temp = stack.pop();
                        if (temp != '(') {
                            isNotCompleted = true;
                        }
                        break;
                    default:
                        stack.push(bracket[i]);
                        break;
                }

                if (isNotCompleted) {
                    break;
                }
            }

            if (isNotCompleted) {
                answer[t] = false;
            }
            else {
                answer[t] = true;
            }
        }

        for (int t = 0; t < 10; t++) {
            if (answer[t]) {
                System.out.println("#" + (t + 1) + " " + 1);
            }
            else {
                System.out.println("#" + (t + 1) + " " + 0);
            }
        }
    }

    class Stack {
        char[] data;
        int top = 0;

        Stack(int n) {
            data = new char[n];
            top = 0;
        }

        public void push(char c) {
            data[top] = c;
            top++;
        }

        public char pop() {
            top--;
            return data[top];
        }
    }
}
