package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_9414 extends Main {
    public void run() {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        int arrNum = 40;
        int[] arr = new int[arrNum];
        int arrIndex = 0;
        int[] answer = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            arrIndex = 0;
            int n = 0;
            int temp;
            // 입력이랑 정렬
            while (true) {
                n = scan.nextInt();
                if (n == 0) break;

                arrIndex++;
                // 삽입 정렬
                for (int j = 0; j < arrIndex; j++) {
                    if (arr[j] < n) {
                        temp = arr[j];
                        arr[j] = n;
                        n = temp;
                    }
                }
            }

            int mul = 1;
            int sum = 0;
            for (int j = 0; j < arrIndex; j++) {
                for (int k = 0; k < j + 1; k++) {
                    mul *= arr[j];
                }

                sum += 2 * mul;
                mul = 1;
            }

            for (int j = 0; j < arrIndex; j++) {
                arr[j] = 0;
            }

            answer[i] = sum;
            // 입력은 0을 입력받을 때까지 입력
            // 땅 값을 큰 수대로 정렬하여 큰 숫자대로 등비수열 계산.
        }

        for (int i = 0; i < testCase; i++) {
            if (answer[i] < 5000000) {
                System.out.println(answer[i]);
            }
            else {
                System.out.println("Too expensive");
            }
        }
    }
    static {
        new baek_9414().run();
    }
}
