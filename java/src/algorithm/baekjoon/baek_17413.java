package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_17413 extends Solution {
    @Override
    public void solution() throws IOException {
        String str = read.readLine();
        char[] arr = str.toCharArray();

        boolean isSwap = true;
        int start = 0, end = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                end = i;

                if (end > 0 || start < end) {
                    swap(arr, start, end);
                }

                isSwap = false;
            }
            else if (arr[i] == '>') {
                isSwap = true;
                start = i + 1;
            }
            else if (arr[i] == ' ') {
                end = i;

                if (isSwap) {
                    swap(arr, start, end);
                }

                start = i + 1;
            }
            else if (i == arr.length - 1) {
                end = arr.length;
                if (isSwap)
                    swap(arr, start, end);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public void swap(char[] arr, int start, int end) {
        int cnt = 1;
        char[] temp = new char[end - start];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[start + i];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[end - i - 1] = temp[i];
        }
    }
}
