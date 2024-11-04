package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2784 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        int N = 6;

        String[] arr = new String[6];
        for (int i = 0; i < N; i++) {
            arr[i] = read.readLine();
        }


    }

    static {
        try {
            new baek_2784().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
