package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_16987 extends Main {
    int N;
    Egg[] eggs;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        N = Integer.parseInt(read.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            /*내구도, 무게*/
            int s, w;
            s = Integer.parseInt(token.nextToken());
            w = Integer.parseInt(token.nextToken());

            eggs[i] = new Egg(s, w);
            eggs[i].crack = false;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    int answer = 0;
    public void dfs(int index, int cnt) {
        if (cnt == N || answer == N) {
            answer = N;
            return;
        }
        if (index >= N) {
            if (answer < cnt)
                answer = cnt;
            return;
        }
        if (eggs[index].s <= 0)
            dfs(index + 1, cnt);
        else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (index == i)
                    continue;
                if (eggs[i].s <= 0)
                    continue;

                flag = true;
                eggs[index].s -= eggs[i].w;
                eggs[i].s -= eggs[index].w;

                int amount = 0;
                if (eggs[index].s <= 0) {
                    amount++;
                }
                if (eggs[i].s <= 0) {
                    amount++;
                }

                dfs(index + 1, cnt + amount);

                eggs[index].s += eggs[i].w;
                eggs[i].s += eggs[index].w;
            }

            if (!flag)
                dfs(index + 1, cnt);
        }
    }

    class Egg {
        /*내구도, 무게*/
        int s, w;
        boolean crack;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
    }
    static {
        try {
            new baek_16987().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
