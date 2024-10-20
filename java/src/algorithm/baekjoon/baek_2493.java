package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2493 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());
        int[] top = new int[N];

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(token.nextToken());
        }

        int[] answer = new int[N];
        answer[0] = 0;

        Stack stack = new Stack(N);
        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (true) {
                int tempIndex = stack.peek();

                if (top[tempIndex] < top[i]) {
                    stack.pop();
                }
                else {
                    answer[i] = tempIndex + 1;
                    break;
                }

                if (stack.isEmpty()) {
                    answer[i] = 0;
                    break;
                }
            }

            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    class Stack {
        int[] data;
        int top;

        Stack(int n) {
            data = new int[n];
            top = -1;
        }

        public void push(int n) {
            top++;
            data[top] = n;
        }

        public int pop() {
            top--;
            return data[top + 1];
        }

        public int peek() {
            return data[top];
        }

        public boolean isEmpty() {
            return top == -1 ? true : false;
        }
    }
    static {
        try {
            new baek_2493().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
