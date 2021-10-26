package algorithm.swexpert;

import algorithm.SolutionImpl;

import java.util.Scanner;

public class expert_1208 implements SolutionImpl{
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int T = 10;

        int[] answer = new int[T];
        for (int test_case = 0; test_case < T; test_case++) {

            int dumpCount = scan.nextInt();

            int boxesLength = 100;
            int[] boxes = new int [boxesLength];

            for (int i = 0; i < boxesLength; i++) {
                boxes[i] = scan.nextInt();
            }

            for (int i = 0; i < dumpCount; i++) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                int maxIndex = 0, minIndex = 0;

                for (int j = 0; j < boxesLength; j++) {
                    if (max < boxes[j]) {
                        max = boxes[j];
                        maxIndex = j;
                    }
                    if (min > boxes[j]) {
                        min = boxes[j];
                        minIndex = j;
                    }
                }

                if (boxes[maxIndex] - boxes[minIndex] == 1) break;

                boxes[maxIndex]--;
                boxes[minIndex]++;
            }

            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < boxesLength; i++) {
                if (max < boxes[i]) {
                    max = boxes[i];
                }
                if (min > boxes[i]) {
                    min = boxes[i];
                }
            }

            answer[test_case] = max - min;
        }


        for (int tset_case = 0; tset_case < T; tset_case++) {
            System.out.println("#" + (tset_case + 1) + " " + answer[tset_case]);
        }
    }

    int[] reBoxes = new int[100];
    int[] answer = new int[10];
    int reculsiveMax = 0;
    int reculsiveMin = Integer.MAX_VALUE;

    public void reculsive(int n) {
        if (n == 0) {
            return;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < 100; i++) {
            if (max < reBoxes[i]) {
                max = reBoxes[i];
                maxIndex = i;
            }
            if (min > reBoxes[i]) {
                min = reBoxes[i];
                minIndex = i;
            }
        }

        if (reBoxes[maxIndex] - reBoxes[minIndex] == 1) {
            return;
        }

        reBoxes[maxIndex]--;
        reBoxes[minIndex]++;

        reculsive(n - 1);
    }
}
