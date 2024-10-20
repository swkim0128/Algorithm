package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_2941 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        String croatia = read.readLine();
        char[] croatiaAlpha = croatia.toCharArray();

        int[] select = new int[croatiaAlpha.length];
        int start = 0;

        while (start < croatiaAlpha.length) {
            if (start + 1 >= croatiaAlpha.length) {
                select[start] = 1;
                start += 1;
                continue;
            }
            if (start + 2 < croatiaAlpha.length) {
                if (croatiaAlpha[start] == 'd' && croatiaAlpha[start + 1] == 'z' && croatiaAlpha[start + 2] == '=') {
                    select[start] = 1;
                    start += 3;
                    continue;
                }
            }

            if (croatiaAlpha[start + 1] == '=' && (croatiaAlpha[start] == 'c' || croatiaAlpha[start] == 's' || croatiaAlpha[start] == 'z')) {
                select[start] = 1;
                start += 2;
            }
            else if (croatiaAlpha[start + 1] == '-' && (croatiaAlpha[start] == 'c' || croatiaAlpha[start] == 'd')) {
                select[start] = 1;
                start += 2;
            }
            else if (croatiaAlpha[start + 1] == 'j' && (croatiaAlpha[start] == 'l' || croatiaAlpha[start] == 'n')) {
                select[start] = 1;
                start += 2;
            }
            else {
                select[start] = 1;
                start += 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < croatiaAlpha.length; i++) {
            answer += select[i];
        }

        System.out.println(answer);
    }
    static {
        try {
            new baek_2941().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
