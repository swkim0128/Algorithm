package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_9242 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N = 5;
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = read.readLine();
        }

        // algo
        int strLen = arr[0].length();

        ArrayList<String[]> codeStr = new ArrayList<>();
        for (int i = 0; i < strLen; i = i + 4) {
            String[] temp = new String[N];
            for (int j = 0; j < N; j++) {
                if (i + 3 > arr[j].length())
                    temp[j] = "*  ";
                else
                    temp[j] = arr[j].substring(i, i + 3);
            }

            codeStr.add(temp);
        }

        String temp = "";
        for (int i = 0; i < codeStr.size(); i++) {
            int tmp = isNum(codeStr.get(i));
            if (tmp == -1) {
                System.out.println("BOOM!!");
                return;
            }
            temp += tmp;
        }

        // output
        int tempN = Integer.parseInt(temp);

        if (tempN % 6 == 0)
            System.out.println("BEER!!");
        else
            System.out.println("BOOM!!");
    }

    public int isNum(String[] num) {
        String[][] number = {
                {"***", "* *", "* *", "* *", "***"}, // 0
                {"  *", "  *", "  *", "  *", "  *"}, // 1
                {"***", "  *", "***", "*  ", "***"}, // 2
                {"***", "  *", "***", "  *", "***"}, // 3
                {"* *", "* *", "***", "  *", "  *"}, // 4
                {"***", "*  ", "***", "  *", "***"}, // 5
                {"***", "*  ", "***", "* *", "***"}, // 6
                {"***", "  *", "  *", "  *", "  *"}, // 7
                {"***", "* *", "***", "* *", "***"}, // 8
                {"***", "* *", "***", "  *", "***"}  // 0
        };

        boolean isEquals = false;
        int result = -1;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (num[j].equals(number[i][j]))
                    isEquals = true;
                else {
                    isEquals = false;
                    break;
                }
            }

            if (isEquals) {
                result = i;
                break;
            }
        }

        return result;
    }
}
