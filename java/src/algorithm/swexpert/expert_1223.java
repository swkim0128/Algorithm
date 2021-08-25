package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class expert_1223 extends Solution {
    @Override
    public void solution() throws IOException {
        int[] answer = new int[10];
        for (int t = 0;t < 10; t++) {
            int N = Integer.parseInt(read.readLine());
            String formular = read.readLine();

            char[] rearFormular = new char[N];
            int rearSize = 0;
            Stack<Character> operator = new Stack<>();
            for (int i = 0; i < N; i++) {
                char operation = formular.charAt(i);

                switch (operation) {
                    case '+':
                        if (!operator.isEmpty()) {
                            rearFormular[rearSize] = operator.pop();
                            rearSize++;
                        }
                        operator.push(operation);
                        break;
                    case '*':
                        operator.push(operation);
                        i++;
                        rearFormular[rearSize] = formular.charAt(i);
                        rearSize++;
                        rearFormular[rearSize] = operator.pop();
                        rearSize++;

                        if (i + 1 < N && formular.charAt(i + 1) != '*') {
                            if (!operator.isEmpty()) {
                                rearFormular[rearSize] = operator.pop();
                                rearSize++;
                            }
                        }
                        break;
                    default:
                        rearFormular[rearSize] = operation;
                        rearSize++;
                        break;
                }
            }
            while (!operator.isEmpty()) {
                rearFormular[rearSize] = operator.pop();
                rearSize++;
            }

            Stack<Integer> operand = new Stack<>();
            for (int i = 0; i < N; i++) {
                char temp = rearFormular[i];

                int x, y;
                switch (temp) {
                    case '+':
                        x = operand.pop();
                        y = operand.pop();
                        operand.push(x + y);
                        break;
                    case '*':
                        x = operand.pop();
                        y = operand.pop();
                        operand.push(x * y);
                        break;
                    default:
                        operand.push(temp - '0');
                        break;
                }
            }

            answer[t] = operand.pop();
        }

        for (int t = 0; t < 10; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }
}
