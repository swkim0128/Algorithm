package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_29704 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        int N, T;

        // input
        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());

        Integer[][] arr = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }

        // algo
        //

//        Collections.sort(arr, (o1, o2) -> {});
    }
    static {
        try {
            new baek_29704().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
