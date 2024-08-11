package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.*;

public class baek_1935 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());
        String str = read.readLine();

        List<Double> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            double num = Integer.parseInt(read.readLine());
            numList.add(num);
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                double tmp = numList.get(str.charAt(i) - 'A');
                stack.add(tmp);
            }
            else {
                char tmpChar = str.charAt(i);

                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                double resultTmp = 0;
                switch (tmpChar) {
                    case '+':
                        resultTmp = tmp2 + tmp1;
                        break;
                    case '-':
                        resultTmp = tmp2 - tmp1;
                        break;
                    case '*':
                        resultTmp = tmp2 * tmp1;
                        break;
                    case '/':
                        resultTmp = tmp2 / tmp1;
                        break;
                }

                stack.add(resultTmp);
            }
        }

        double result = stack.pop();
        System.out.println(String.format("%.2f", result));
    }
}
