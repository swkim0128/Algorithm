package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_22115 extends Main {
    static int N, K;
    static Integer[] C;
    static boolean isEnd = false;
    static int result = -1;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(read.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());
        C = new Integer[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(C, Comparator.reverseOrder());

        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            numbers.add(new ArrayList<>());
            List<Integer> idxs = numbers.get(i);


        }
//        int[] numbers = new int[K];
//        for (int i = 0; i < N; i++) {
//            for (int j = i; j < N; j++) {
//                if (i == 0){
//                    numbers[i] = C[j];
//                } else {
//                    numbers[i] = numbers[i - 1] + C[j];
//                }
//
//                if (numbers[i] < K) {
//                    break;
//                } else if (numbers[i] == K) {
//                    result = i + 1;
//                    isEnd = true;
//                    break;
//                }
//            }
//
//            if (isEnd) {
//                break;
//            }
//        }

        System.out.println(result);
    }

    static {
        try {
            new baek_22115().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
