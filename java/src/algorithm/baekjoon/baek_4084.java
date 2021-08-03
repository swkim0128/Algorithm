package algorithm.baekjoon;

import algorithm.SolutionImpl;
import com.sun.tools.internal.ws.processor.modeler.wsdl.PseudoSchemaBuilder;

import java.util.Scanner;

public class baek_4084 implements SolutionImpl {
    @Override
    public void solution() {
        Scanner scan = new Scanner(System.in);
        int a, b, c, d;

        while (true) {
            int answer = 0;

            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            d = scan.nextInt();

            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }

            while (true) {
                if (a == b && b == c && c == d && d == a) {
                    System.out.println(answer);
                    break;
                }

                int temp = a;
                a = Math.abs(a - b);
                b = Math.abs(b - c);
                c = Math.abs(c - d);
                d = Math.abs(d - temp);

                answer++;
            }
        }
    }
}
