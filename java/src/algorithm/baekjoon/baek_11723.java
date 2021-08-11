package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_11723 extends Solution {
    @Override
    public void solution() throws IOException {
        int M = Integer.parseInt(read.readLine());

        int S = 0;
        StringTokenizer token;
        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            String order = token.nextToken();
            int n;

            int operand;
            switch (order) {
                case "add":
                    n = Integer.parseInt(token.nextToken());
                    operand = 1 << n;
                    S |= operand;
                    break;
                case "remove":
                    n = Integer.parseInt(token.nextToken());
                    operand = 1 << n;
                    operand = ~operand;
                    S &= operand;
                    break;
                case "check":
                    n = Integer.parseInt(token.nextToken());
                    operand = 1 << n;

                    write.write(((S & operand) >> n) + '0');
                    write.newLine();
                    break;
                case "toggle":
                    n = Integer.parseInt(token.nextToken());
                    operand = 1 << n;
                    S = ~S;
                    S ^= operand;
                    S = ~S;
                    break;
                case "all":
                    operand = -1;
                    S |= operand;
                    break;
                case "empty":
                    operand = 0;
                    S &= operand;
                    break;
            }

            write.flush();
        }
    }
}
