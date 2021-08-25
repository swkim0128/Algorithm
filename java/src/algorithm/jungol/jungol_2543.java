package algorithm.jungol;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class jungol_2543 extends Solution {
    int[][] map;

    @Override
    public void solution() throws IOException {
        int N = Integer.parseInt(read.readLine());
        map = new int[N][N];

        int r, c;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());


    }

    public void setTile(int r, int c, int size, int position) {
        if (size == 2) {
            switch (position) {
                case 4:
                    map[r][r] = 4;
                    map[r][r + 1] = 4;
                    map[r + 1][r] = 4;
                    break;
                case 3:
                    map[r][r] = 3;
                    map[r][r + 1] = 3;
                    map[r + 1][r + 1] = 3;
                    break;
                case 2:
                    map[r][r] = 2;
                    map[r + 1][r] = 2;
                    map[r + 1][r + 1] = 2;
                    break;
                case 1:
                    map[r][r + 1] = 1;
                    map[r + 1][r] = 1;
                    map[r + 1][r + 1] = 1;
                    break;
            }
        }
        else if (size == 4) {
            switch (position) {
                case 4:
                    break;
                case 3:
                    break;
                case 2:
                    break;
                case 1:
                    break;
            }
        }

        setTile(r, c, size / 2, 4);
        setTile(r, c + size / 2, size / 2, 3);
        setTile(r + size / 2, c, size / 2, 2);
        setTile(r + size / 2, c + size / 2, size / 2, 1);
    }
}
