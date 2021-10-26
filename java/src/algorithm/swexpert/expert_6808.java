package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class expert_6808 extends Solution {
    final int CARD_SIZE = 9;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int[] cards = new int[CARD_SIZE * 2 + 1];
            int[] gCards = new int[CARD_SIZE];
            int[] iCards = new int[CARD_SIZE];

            for (int i = 0; i < CARD_SIZE; i++) {
                gCards[i] = Integer.parseInt(token.nextToken());
                cards[gCards[i]] = 1;
            }

            int iSetIndex = 0;
            for (int i = 1; i < CARD_SIZE * 2 + 1; i++) {
                if (cards[i] == 0) {
                    iCards[iSetIndex] = i;
                    iSetIndex++;
                }
            }

            int gWinCnt = 0;
            int iWinCnt = 0;

            do {
                int gSum = 0;
                int iSum = 0;

                for (int i = 0; i < CARD_SIZE; i++) {
                    if (gCards[i] > iCards[i]) {
                        gSum += gCards[i] + iCards[i];
                    }
                    else {
                        iSum += gCards[i] + iCards[i];
                    }
                }

                if (gSum > iSum) {
                    gWinCnt++;
                }
                else {
                    iWinCnt++;
                }

            } while (np(iCards));

            System.out.println("#" + (t + 1) + " " + gWinCnt + " " + iWinCnt);
        }
    }

    public boolean np(int[] number) {
        int N = number.length;

        int i = N - 1;
        while (i > 0 && number[i - 1] >= number[i])
            i--;

        if (i == 0) {
            return false;
        }

        int j = N - 1;
        while (number[i - 1] >= number[j])
            j--;

        swap(number, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(number, i, k);
            i++;
            k--;
        }

        return true;
    }

    public void swap(int[] number, int i, int j) {
        int temp = number[i];
        number[i] = number[j];
        number[j] = temp;
    }
}
