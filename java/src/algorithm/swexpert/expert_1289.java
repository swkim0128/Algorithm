package algorithm.swexpert;

import algorithm.SolutionImpl;

import java.util.Arrays;
import java.util.Scanner;

public class expert_1289 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        String temp;
        for (int i = 0; i < T; i++) {
            temp = scan.next();
            char[] binaryArr = temp.toCharArray();
            char[] initalArr = new char[temp.length()];

            Arrays.fill(initalArr, '0');

            int answer = 0;
            for (int j = 0; j < binaryArr.length; j++) {
                if (binaryArr[j] == initalArr[j]) {
                    continue;
                }
                else {
                    for (int k = j; k < binaryArr.length; k++) {
                        if (binaryArr[j] == '1') {
                            initalArr[k] = '1';
                        }
                        else {
                            initalArr[k] = '0';
                        }
                    }

                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
