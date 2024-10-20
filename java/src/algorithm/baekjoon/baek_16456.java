package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class baek_16456 extends Main {
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(read.readLine());
    }

    static {
        try {
            new baek_16456().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
