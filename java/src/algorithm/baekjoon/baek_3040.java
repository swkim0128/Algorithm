package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;

public class baek_3040 extends Solution {
    final int DWARF_NUM = 9;
    final int ANSWER_NUM = 7;

    int[] dwarf;
    int[] res = new int[ANSWER_NUM];
    int[] answer = new int[ANSWER_NUM];

    @Override
    public void solution() throws IOException {
        dwarf = new int[DWARF_NUM];

        for (int i = 0; i < DWARF_NUM; i++) {
            dwarf[i] = Integer.parseInt(read.readLine());
        }

        combi(0, 0, 0);

        for (int i = 0; i < ANSWER_NUM; i++) {
            System.out.println(dwarf[answer[i]]);
        }
    }

    public void combi(int cnt, int start, int amount) {
        if (cnt == ANSWER_NUM) {
            if (amount == 100) {
                for (int i = 0; i < ANSWER_NUM; i++) {
                    answer[i] = res[i];
                }
            }

            return;
        }

        for (int i = start; i < DWARF_NUM; i++) {
            res[cnt] = i;
            combi(cnt + 1, ++start, amount + dwarf[i]);
        }
    }
}
