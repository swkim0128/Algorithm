package algorithm.swexpert;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class expert_1210 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int T = 10;

        int[] answer = new int[10];
        for (int testCase = 0; testCase < T; testCase++) {
            int ladderLength = 100;
            int[][] ladderArr = new int [ladderLength][ladderLength];
            int test = scan.nextInt();

            for (int i = 0; i < ladderLength; i++) {
                for (int j = 0; j < ladderLength; j++) {
                    ladderArr[i][j] = scan.nextInt();
                }
            }

            int[] startLadder = new int[ladderLength];
            int startLadderIndex = 0;
            int endLadderIndex = 0;

            for (int i = 0; i < ladderLength; i++) {
                if (ladderArr[0][i] == 1) {
                    startLadder[startLadderIndex] = i;

                    if (ladderArr[99][i] == 2) {
                        endLadderIndex = startLadderIndex;
                    }
                    startLadderIndex++;
                }
            }

            startLadderIndex--;
            int next = startLadder[endLadderIndex];
            int nextIndex = endLadderIndex;
            for (int i = 99; i >= 0; i--) {
                if (nextIndex == 0) {
                    if (ladderArr[i][next + 1] == 1) {
                        nextIndex++;
                        next = startLadder[nextIndex];
                    }
                    continue;
                }
                else if (nextIndex == startLadderIndex) {
                    if (ladderArr[i][next - 1] == 1) {
                        nextIndex--;
                        next = startLadder[nextIndex];
                    }
                    continue;
                }

                if (ladderArr[i][next + 1] == 1) {
                    nextIndex++;
                    next = startLadder[nextIndex];
                }
                else if (ladderArr[i][next - 1] == 1) {
                    nextIndex--;
                    next = startLadder[nextIndex];
                }
            }

            answer[testCase] = next;
        }

        for (int testCase = 0; testCase < T; testCase++) {
            System.out.println("#" + (testCase + 1) + " " + answer[testCase]);
        }
    }
}
