package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class baek_27919 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        
        // input
        String V;

        V = read.readLine();

        // algo
        // 한 마스코트가 받은 표의 수가 다른 두 마스코트가 각각 받은 표의 수보다 모두 크다면 그 마스코트가 제일 귀여운 마스코트
        // U가 받을 수 있는 최대수, D가 받을 수 있는 최대 수, P가 받을 수 있는 최대 수
        Map<String, Integer> map = new HashMap<>();
        map.put("U", 0);
        map.put("D", 0);
        map.put("P", 0);
        map.put("C", 0);

        for (int i = 0; i < V.length(); i++) {
            String c = Character.toString(V.charAt(i));
            int tmp = map.get(c) + 1;
            map.put(c, tmp);
        }

        int uCnt = map.get("U");
        int cCnt = map.get("C");
        int dCnt = map.get("D");
        int pCnt = map.get("P");

        int ucCnt = uCnt + cCnt;
        int dpCnt = dCnt + pCnt;

        // U 만 있을 격우, C만 있을 경우, D만 있을 경우, P만 있을 경우
        // uuddppcc
        int halfDp = dpCnt % 2 == 0 ? dpCnt / 2 : dpCnt / 2 + 1;

        String result = "";
        if (ucCnt > halfDp) result += "U";
        if (dpCnt > 0) result += "DP";

        System.out.println(result);
    }
    static {
        try {
            new baek_27919().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
