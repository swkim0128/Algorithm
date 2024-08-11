package algorithm.programmers;

import algorithm.Solution;

import javax.swing.plaf.IconUIResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test02 extends Solution {
    @Override
    public void solution() throws IOException {
        String[] grid = {"aa?"};

        N = grid.length;
        M = grid[0].length();

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = grid[i].charAt(j);
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '?')
                    list.add(new Point(i, j));
            }
        }

        COUNT_N = list.size();

        dfs(0);
        System.out.println(answer);
    }

    int N, M;
    char[][] arr;
    ArrayList<Point> list;
    int COUNT_N = 0;
    char[] ch = { 'a', 'b', 'c' };

    int answer = 0;
    public void dfs(int cnt) {
        if (cnt == COUNT_N) {
            if (bfs(arr)) answer++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            Point p = list.get(cnt);
            arr[p.r][p.c] = ch[i];
            dfs(cnt + 1);
        }
    }

    public boolean bfs(char[][] arr) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        boolean[] visitedChar = new boolean[3];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                int chIndex = 0;
                if (arr[i][j] == 'a') chIndex = 0;
                else if (arr[i][j] == 'b') chIndex = 1;
                else if (arr[i][j] == 'c') chIndex = 2;

                if (visitedChar[chIndex]) return false;
                queue.offer(new Point(i, j));
                visited[i][j] = true;
                visitedChar[chIndex] = true;

                while (!queue.isEmpty()) {
                    Point p = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nr = p.r + dr[k];
                        int nc = p.c + dc[k];

                        if (nr < 0 || N <= nr || nc < 0 || M <= nc) continue;
                        if (arr[nr][nc] != ch[chIndex]) continue;
                        if (visited[nr][nc]) continue;

                        queue.offer(new Point(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                else return false;
            }
        }

        return true;
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
