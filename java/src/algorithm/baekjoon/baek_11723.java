package algorithm.baekjoon;

import algorithm.Main;

import java.io.*;
import java.util.StringTokenizer;

public class baek_11723 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

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
    static {
        try {
            new baek_11723().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
