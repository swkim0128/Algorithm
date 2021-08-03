package algorithm.baekjoon;

import algorithm.SolutionImpl;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_19575 implements SolutionImpl {
    @Override
    public void solution() throws IOException {
//        Scanner scan = new Scanner(System.in);
        final int num = 1000000007;

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(scan.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long result = 0;
        long A, i;
        boolean flag = true;
        for (int j = 0; j <= N; j++) {
            st = new StringTokenizer(scan.readLine(), " ");
            A = Long.parseLong(st.nextToken());
            i = Long.parseLong(st.nextToken());

            if (flag) {
                result = A;
                flag = false;
            }
            else {
                result = (result * x + A) % num;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
