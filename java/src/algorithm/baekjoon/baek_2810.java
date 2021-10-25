package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_2810 extends Solution {
    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());
        String seat = read.readLine();
        int seatCnt = seat.length();

        char[] cupHolder = seat.toCharArray();
        int cupCnt = 1;
        for (int i = 0; i < cupHolder.length; i++) {
            switch (cupHolder[i]) {
                case 'S':
                    cupCnt++;
                    break;
                case 'L':
                    i++;
                    cupCnt++;
                    break;
            }
        }

        if (seatCnt < cupCnt) {
            System.out.println(seatCnt);
        }
        else
            System.out.println(cupCnt);
    }
}