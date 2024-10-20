package algorithm.baekjoon;

import algorithm.Main;

import java.io.*;
import java.util.StringTokenizer;

public class baek_19575 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));//        Scanner scan = new Scanner(System.in);
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
    static {
        try {
            new baek_19575().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
