package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.*;

public class baek_29704 extends Solution {

    @Override
    public void solution() throws IOException {
        int N, T;

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
}
