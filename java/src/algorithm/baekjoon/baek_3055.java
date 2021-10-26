package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_3055 extends Solution {
    int R, C;

    @Override
    public void solution() throws IOException {
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = read.readLine().toCharArray();
        }

        ArrayList<Point> water = new ArrayList<>();
        Point end = null;
        Point hog = null;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*')
                    water.add(new Point(i, j, 0));
                else if (map[i][j] == 'D')
                    end = new Point(i, j);
                else if (map[i][j] == 'S')
                    hog = new Point(i, j);
            }
        }

        System.out.println(moveWater(map, water, end, hog));
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public String moveWater(char[][] map, ArrayList<Point> water, Point end, Point hog) {
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < water.size(); i++) {
            queue.offer(water.get(i));
        }

        int[][] visited = moveHog(map, hog);
        int answer = visited[end.r][end.c] - 1;

        int count = 0;

        ArrayList<Point> list = new ArrayList<>();
        for (int n = 0; n < answer; n++) {
            boolean isContinue = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (visited[i][j] - 1 == n && map[i][j] != '*')
                        isContinue = true;
                }
            }

            if (!isContinue)
                return "KAKTUS";

            while (!list.isEmpty()) {
                queue.offer(list.remove(0));
            }

            while (!queue.isEmpty()) {
                Point point = queue.poll();

                int nr, nc;
                for (int i = 0; i < 4; i++) {
                    nr = point.r + dr[i];
                    nc = point.c + dc[i];

                    if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                        continue;
                    if (map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'D')
                        continue;

                    map[nr][nc] = '*';
                    list.add(new Point(nr, nc, point.depth + 1));
                }

            }
        }
        return String.valueOf(answer);
    }

    public int[][] moveHog(char[][] map, Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);

        int[][] visited = new int[R][C];
        visited[p.r][p.c] = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (map[point.r][point.c] == 'D') {
                break;
            }

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = point.r + dr[i];
                nc = point.c + dc[i];

                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (visited[nr][nc] != 0)
                    continue;
                if (map[nr][nc] == '*' || map[nr][nc] == 'X')
                    continue;

                visited[nr][nc] = visited[point.r][point.c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }

        return visited;
    }

    public boolean bfs(char[][] map, Point p) {
        if (map[p.r][p.c] == '*')
            return false;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);

        int[][] visited = new int[R][C];
        visited[p.r][p.c] = 1;

        boolean result = false;
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (map[point.r][point.c] == 'D') {
                result = true;
                break;
            }

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = point.r + dr[i];
                nc = point.c + dc[i];

                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (visited[nr][nc] != 0)
                    continue;
                if (map[nr][nc] == '*' || map[nr][nc] == 'X')
                    continue;

                visited[nr][nc] = visited[point.r][point.c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }

        return result;
    }

    class Point {
        int r, c;
        int depth;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Point(int r, int c, int d) {
            this(r, c);
            this.depth = d;
        }
    }

    class Hog {
        int r, c;

        Hog(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
