package algorithm.baekjoon;

import algorithm.Main;

import java.util.Scanner;

public class baek_10892 extends Main {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] x = new int[3 * N];
        int[] y = new int[3 * N];

        for (int i = 0; i < 3 * N; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }

        // answer
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];

        // 임의의 세 점을 뽑는 법.
        // 입력한 순서대로 세 점을 받은 뒤
        // 넓이 계산.

        // 선이 겹치는 조건
        // 세 점 안에 점이 있으면 안됨.

        // 넓이가 다르면 다시
    }
    static {
        new baek_10892().run();
    }
}
