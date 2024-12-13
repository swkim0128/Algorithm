package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2290 extends Main {
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        int S = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
    }

    static {
        try {
            new baek_2290().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
