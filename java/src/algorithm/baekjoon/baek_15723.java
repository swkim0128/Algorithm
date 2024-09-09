package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class baek_15723 extends Solution {
    @Override
    public void solution() throws IOException {
        int n;
        int m;

        // input
        n = Integer.parseInt(read.readLine());
        String[] strN = new String[n];
        for (int i = 0; i < n; i++) {
            strN[i] = read.readLine();
        }

        m = Integer.parseInt(read.readLine());
        String[] strM = new String[m];
        for (int i = 0; i < m; i++) {
            strM[i] = read.readLine();
        }

        // algo
        // strN: 방향 그래프
        Map<String, String> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] temp = strN[i].split(" is ");
            graph.put(temp[0], temp[1]);
        }

        // strM
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            String[] temp = strM[i].split(" is ");
            String a = temp[0];
            String b = temp[1];

            result[i] = "F";
            while (graph.containsKey(a)) {
                a = graph.get(a);
                if (b.equals(a)) {
                    result[i] = "T";
                    break;
                }
            }
        }

        // output
        for (int i = 0; i < m; i++) {
            System.out.println(result[i]);
        }
    }
}
