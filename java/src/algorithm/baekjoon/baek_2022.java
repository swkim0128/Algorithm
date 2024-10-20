package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2022 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        double x, y, c;

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        x = Double.parseDouble(token.nextToken());
        y = Double.parseDouble(token.nextToken());
        c = Double.parseDouble(token.nextToken());


    }
    static {
        try {
            new baek_2022().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
