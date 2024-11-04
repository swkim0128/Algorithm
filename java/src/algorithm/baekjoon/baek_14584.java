package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_14584 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        String cipher = read.readLine();
        int N = Integer.parseInt(read.readLine());

        String[] diction = new String[N];
        for (int i = 0; i < N; i++) {
            diction[i] = read.readLine();
        }

        // algo
        // 'a' : 97
        int alpaLen = 26;
        int cipherCnt = 0;
        boolean isContinue = true;
        String result = "";
        for (int i = 1; i < alpaLen + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cipher.length(); j++) {
                // z + 1 = a
                char tmpCh = cipher.charAt(j);
                tmpCh = (int) tmpCh + i > 'z' ? (char) ('a' + ((tmpCh + i) - 'z' - 1)) : (char) (tmpCh + i);

                sb.append(tmpCh);
            }

            String answer = sb.toString();

            for (String d : diction) {
                if (answer.matches(".*"+d+".*")) {
                    result = answer;
                    isContinue = false;
                    break;
                }
            }

            if (!isContinue) {
                break;
            }
        }

        System.out.println(result);
    }

    static {
        try {
            new baek_14584().run();
        }
        catch (IOException e) {

        }
    }
}
