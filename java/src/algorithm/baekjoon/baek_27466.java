package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_27466 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N, M;
        String S;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        S = read.readLine();

        // algo
        // 맨 뒷글자는 알파벳 자음(A부터 Z 중 A, E, I, O, U를 제외한 글자들)이고, 뒤에서부터 각각 두 번째와 세 번째 글자는 A인 문자열이다.

        int count = 1 << N;
        for (int i = 0; i < count; i++) {

            ArrayList<Integer> indexs = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if ((i & (1 << j)) == 0) {
                    indexs.add(j);
                }
            }
        }
    }
    static {
        try {
            new baek_27466().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
