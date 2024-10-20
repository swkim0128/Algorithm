package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1759 extends Main {
    int L, C;

    char[] arr;
    boolean[] visited;

    char[] answer;
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        L = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine(), " ");

        arr = new char[C];
        visited = new boolean[C];

        answer = new char[L];

        for (int i = 0; i < C; i++) {
            arr[i] = token.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        combi(0, 0, 0, 0);
    }

    public void combi(int cnt, int start, int vowel, int consonant) {
        if (cnt == L) {
            if (vowel < 1)
                return;
            if (consonant < 2)
                return;

            for (int i = 0; i < L; i++) {
                System.out.print(answer[i]);
            }
            System.out.println();

            return;
        }

        for (int i = start; i < C; i++) {
            int vowelCnt = 0;
            int consonantCnt = 0;

            switch (arr[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowelCnt++;
                    break;
                default:
                    consonantCnt++;
                    break;
            }

            answer[cnt] = arr[i];
            combi(cnt + 1, ++start, vowel + vowelCnt, consonant + consonantCnt);
        }
    }
    static {
        try {
            new baek_1759().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
