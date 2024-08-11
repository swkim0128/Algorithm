package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek_1283 extends Solution {

    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());

        Map<String, Boolean> isUsed = new HashMap<>();
        for (int n = 0; n < N; n++); {
            StringTokenizer tokenizer = new StringTokenizer(read.readLine(), " ");
            int tokenSize = tokenizer.countTokens();
            String[] tempStr = new String[tokenSize];

            for (int i = 0; i < tokenSize; i++) {
                tempStr[i] = tokenizer.nextToken();
            }

            boolean isContinue = true;
            for (int i = 0; i < tokenSize; i++) {
                for (int j = 0; j < tempStr[i].length(); j++) {
                    System.out.println(tempStr[i].charAt(j));
                    if (isUsed.get(tempStr[i].charAt(j))) {
                        continue;
                    }
                    else {
                        isUsed.put(new StringBuilder().append(tempStr[i].charAt(j)).toString(), true);
                        isContinue = false;
                        break;
                    }
                }

                if (!isContinue) {
                    break;
                }
            }
        }
    }
}
