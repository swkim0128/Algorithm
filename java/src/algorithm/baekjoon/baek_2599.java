package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2599 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // input
        int N;
        int aM, aF;
        int bM, bF;
        int cM, cF;

        N = Integer.parseInt(read.readLine());

        StringTokenizer token = new StringTokenizer(read.readLine());
        aM = Integer.parseInt(token.nextToken());
        aF = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());
        bM = Integer.parseInt(token.nextToken());
        bF = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine());
        cM = Integer.parseInt(token.nextToken());
        cF = Integer.parseInt(token.nextToken());

        // algo
        // A 남자 짝
        //
        int result = 1;

        if (aM + bM + cM != N && aF + bF + cF != N) {
            System.out.println(0);
            return;
        }

        int a1 = 0, a2 = 0, b1 = 0, b2 = 0, c1 = 0, c2 = 0;

        if (aM == bF + cF) {
            a1 = bF;
            a2 = cF;

            bF = 0;
            cF = 0;

            if (bM + cM == aF) {
                b1 = bM;
                b2 = 0;
                c1 = cM;
                c2 = 0;
            }
            else {
                result = 0;
            }
        }
        else if (aM < bF + cF) {
            if (aM <= bF) {
                a1 = aM;
                a2 = 0;
                bF = bF - a1;
            }
            else {
                a1 = bF;
                a2 = aM - a1;
                bF = 0;
                cF = cF - a2;
            }

            if (bM + cM == aF + bF + cF) {
                if (bM <= aF) {
                    b1 = bM;
                    b2 = 0;
                    c1 = aF - b1;
                    c2 = cM - c1;
                }
                else {
                    b1 = aF;
                    b2 = bM - b1;
                    c1 = 0;
                    c2 = cM - c2;
                }
            }
            else {
                result = 0;
            }
        }
        else {
            result = 0;
        }

        if (result == 0) {
            System.out.println(result);
        }
        else {
            System.out.println(result);
            System.out.println(a1 + " " + a2);
            System.out.println(b1 + " " + b2);
            System.out.println(c1 + " " + c2);
        }
    }
    static {
        try {
            new baek_2599().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
