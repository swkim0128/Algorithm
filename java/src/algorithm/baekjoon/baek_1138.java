package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1138 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        StringTokenizer token = new StringTokenizer(read.readLine());

//        Map<Integer, Integer> map = new SortedMap<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) {
//            map.put(i, Integer.parseInt(token.nextToken()));
        }
    }

    static {
        try {
            new baek_1138().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
