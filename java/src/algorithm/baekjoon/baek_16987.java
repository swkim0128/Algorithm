package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_16987 extends Solution {
    int N;
    Egg[] eggs;

    @Override
    public void solution() throws IOException {
        N = Integer.parseInt(read.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            int s, w;

            s = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());

            eggs[i] = new Egg(s, w);
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    int answer = 0;
    public void dfs(int index, int cnt) {
        if (cnt == N - 1) {
            answer = cnt;
            return;
        }
        if (index == N) {
            answer = N;
            return;
        }
        if (eggs[index].crack) {
            dfs(index + 1, cnt);
        }

        for (int i = 0; i < N; i++) {
            if (index == i)
                continue;
            if (eggs[i].crack)
                continue;

            int c = 0;
            int a = eggs[index].s - eggs[i].w;
            int b = eggs[i].s - eggs[index].w;
            if (a <= 0) {
                eggs[index].crack = true;
                c++;
            }
            if (b <= 0) {
                eggs[i].crack = true;
                c++;
            }
            dfs(index + 1, cnt + c);

            eggs[index].crack = false;
            eggs[i].crack = false;
        }
    }

    class Egg {
        int s, w;
        boolean crack;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
}
