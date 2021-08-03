package algorithm.baekjoon;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class baek_1244 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] switchArr = new int[T];

        for (int i = 0; i < T; i++) {
            switchArr[i] = scan.nextInt();
        }

        int studentN = scan.nextInt();
        int[][] students = new int[studentN][2];

        for (int i = 0; i < studentN; i++) {
            students[i][0] = scan.nextInt();
            students[i][1] = scan.nextInt();
        }

        for (int i = 0; i < studentN; i++) {
            if (students[i][0] == 1) {
                for (int j = 0; j < T; j++) {
                    if ((j + 1) % students[i][1] == 0) {
                        switchArr[j] ^= 1;
                    }
                }
            }
            else if (students[i][0] == 2) {
                int right = students[i][1] - 1;
                int left = students[i][1] - 1;

                while (true) {
                    if (switchArr[left] == switchArr[right]) {
                        right++;
                        left--;
                    }
                    else {
                        right--;
                        left++;
                        break;
                    }

                    if (left < 0 || T <= right) {
                        right--;
                        left++;
                        break;
                    }
                }

                for (int j = left; j < right + 1; j++) {
                    switchArr[j] ^= 1;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.print(switchArr[i] + " ");

            if ((i  + 1) % 20 == 0)
                System.out.println();
        }
    }
}
