package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baek_1205 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        int N, G, P;
        int[] arr = null;

        StringTokenizer token = new StringTokenizer(read.readLine());
        N = Integer.parseInt(token.nextToken());
        // 태수 점수
        G = Integer.parseInt(token.nextToken());
        // 랭킬 리스트에 올라갈 수 있는 P 개수
        P = Integer.parseInt(token.nextToken());

        if (N > 0) {
            arr = new int[N];
            token = new StringTokenizer(read.readLine());
            for (int i = 0; i < N; i++) {
                int t = Integer.parseInt(token.nextToken());
                arr[i] = t;
            }
        }

        // algo
        // 등수 배열
        LinkedList<Integer> gradeList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (!gradeList.contains(arr[i])) {
                gradeList.add(arr[i]);
            }
            else {
                gradeList.add(Integer.MAX_VALUE);
            }
        }

        int result = 1;
        if (gradeList.contains(G)) {
            result = gradeList.indexOf(G) + 1;
            if (result >= P) {
                result = -1;
            }
        }
        else {
            for (int i = 0; i < gradeList.size(); i++) {
                if (i + 1 > P) {
                    result = -1;
                    break;
                }
                if (gradeList.get(i) < G) {
                    result = i + 1;
                    break;
                }
            }
        }

        // output
        System.out.println(result);
    }

    static {
        try {
            new baek_1205().run();
        }
        catch (IOException e) {

        }
    }
    static {
        try {
            new baek_1205().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
