package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2810 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N = Integer.parseInt(read.readLine());
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
    static {
        try {
            new baek_2810().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}