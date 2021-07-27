package algorithm.baekjoon;

import algorithm.SolutionImpl;
import java.util.Scanner;

public class baek_1032 implements SolutionImpl {
    public void solution() {
        Scanner scan = new Scanner(System.in);

        int numberOfFile = scan.nextInt();
        String[] strArray = new String[51];
        int arrayIndex = 0;
        int strLength = 0;

        for (int i = 0; i < numberOfFile; i++) {
            strArray[i] = new String(scan.next());
            arrayIndex++;
        }
        strLength = strArray[0].length();

        char[] compareChar = new char[strLength];
        char[] answer = new char[strLength];

        for (int i = 0; i < strLength; i++) {
            compareChar[i] = strArray[0].charAt(i);
            answer[i] = strArray[0].charAt(i);
        }

        char temp;
        for (int i = 0; i < strLength; i++) {
            for (int j = 1; j < arrayIndex; j++) {
                temp = strArray[j].charAt(i);
                if (compareChar[i] != temp) {
                    answer[i] = '?';
                    break;
                }
                answer[i] = compareChar[i];
            }
        }

        System.out.println(answer);

    }
}
