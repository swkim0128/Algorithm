package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_22846 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int K;
        K = Integer.parseInt(read.readLine());

        // algo
        // 모니터에는 1이 쓰여있고, 칼리부터 번갈아 가면서 게임을 진행한다.
        // 둘은 자신의 차례에 모니터에 쓰여있는 수의 약수를 하나 선택해 모니터에 있는 값에 더한다.
        // 이때 제한 K를 초과한 사람이 패배하게 된다.

        // 1
        // 2 칼리
        // 3 칼리, 링고
        // 4 칼리, 링고
        // 5 칼리, 링고
        // 6 칼리, 링고

        // 칼리, 링고
        System.out.println("Kali");
    }
    static {
        try {
            new baek_22846().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
