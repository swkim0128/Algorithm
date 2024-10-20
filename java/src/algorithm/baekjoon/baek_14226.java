package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_14226 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int S;
        S = Integer.parseInt(read.readLine());

        // algo
        // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
        // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
        // 화면에 있는 이모티콘 중 하나를 삭제한다.

        // 첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.

    }
    static {
        try {
            new baek_14226().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
