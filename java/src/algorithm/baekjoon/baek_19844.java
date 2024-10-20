package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_19844 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        String str = read.readLine();

        // algo
        // 띄어쓰기와 하이픈이 있을 경우 단어를 쪼갬
        String[] strArr = str.split(" |-");

        // c', j', n', m', t', s', l', d', qu'로 시작하고 어포스트로피 뒤 글자가 모음인 경우
        String[] compareStr = {
                "c'", "j'", "n'", "m'", "t'", "s'", "l'", "d'", "qu'"
        };
        // 모음
        Character[] oum = {'a', 'e', 'i', 'o', 'u'};

        int result = 0;
        if (strArr.length == 1) {
            result = 1;
        }
        else {
            result = strArr.length;

            String[] tmpStr = null;
            for (String s : strArr) {
                tmpStr = s.split("c'|j'|n'|m'|t'|s'|l'|d'|qu'");
                if (tmpStr.length <= 1) continue;

                Character tmpCh = tmpStr[1].charAt(0);
                long isOum = Arrays.stream(oum).filter(o -> o.equals(tmpCh)).count();
                if (tmpStr[0].isEmpty() && isOum == 1) {
                    result++;
                }
            }
        }

        // output
        System.out.println(result);
    }
    static {
        try {
            new baek_19844().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
