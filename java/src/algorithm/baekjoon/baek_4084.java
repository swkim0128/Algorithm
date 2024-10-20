package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_4084 extends Main {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        int a, b, c, d;

        while (true) {
            int answer = 0;

            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            d = scan.nextInt();

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }

            while (true) {
                if (a == b && b == c && c == d && d == a) {
                    System.out.println(answer);
                    break;
                }

                int temp = a;
                a = Math.abs(a - b);
                b = Math.abs(b - c);
                c = Math.abs(c - d);
                d = Math.abs(d - temp);

                answer++;
            }
        }
    }
    static {
        new baek_4084().run();
    }
}
