package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_10158 extends Solution {
    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        int w, h;
        w = Integer.parseInt(token.nextToken());
        h = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(read.readLine(), " ");
        int antW, antH;
        antW = Integer.parseInt(token.nextToken());
        antH = Integer.parseInt(token.nextToken());

        int time = Integer.parseInt(read.readLine());

        if (((antW + time) / w) % 2 == 0) {
            antW = (antW + time) % w;
        }
        else {
            antW = w - (antW + time) % w;
        }

        if (((antH + time) / h) % 2 == 0) {
            antH = (antH + time) % h;
        }
        else {
            antH = h - (antH + time) % h;
        }

        StringBuffer str = new StringBuffer();
        str.append(antW).append(" ").append(antH);
        write.write(str.toString());
        write.flush();
    }
}
