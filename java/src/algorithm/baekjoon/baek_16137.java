package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16137 extends Main {
    int N, M;
    int[][] map;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        findCross();
        int answer = bfs();
        System.out.println(answer);
    }

    public void findCross() {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    boolean up = false, right = false, down = false, left = false;
                    int r, c;

                    r = i + dr[0];
                    c = j + dc[0];
                    if (0 <= r && r < N && 0 <= c && c < N) {
                        if (map[r][c] == 0 || map[r][c] > 1)
                            up = true;
                    }

                    r = i + dr[1];
                    c = j + dc[1];
                    if (0 <= r && r < N && 0 <= c && c < N) {
                        if (map[r][c] == 0 || map[r][c] > 1)
                            right = true;
                    }

                    r = i + dr[2];
                    c = j + dc[2];
                    if (0 <= r && r < N && 0 <= c && c < N) {
                        if (map[r][c] == 0 || map[r][c] > 1)
                            down = true;
                    }

                    r = i + dr[3];
                    c = j + dc[3];
                    if (0 <= r && r < N && 0 <= c && c < N) {
                        if (map[r][c] == 0 || map[r][c] > 1)
                            left = true;
                    }

                    if ((up || down) && (right || left))
                        map[i][j] = -1;
                }
            }
        }
    }

    public int bfs() {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        queue.offer(new Point(0, 0));
        visited[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int r = p.r, c = p.c;
            if (r == N - 1 && c == N - 1) {
                if (visited[r][c] == r + c) {
                    answer = visited[r][c];
                    break;
                }
                else {
                    if (answer > visited[r][c])
                        answer = visited[r][c];
                }
            }

            int nr, nc;

            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];

                int t = visited[r][c] + 1;

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (map[nr][nc] == -1)
                    continue;
                if (map[r][c] == 0 && map[nr][nc] == 0)
                    continue;
                if (visited[nr][nc] != -1)
                    continue;

                if (map[nr][nc] == 1) {
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = t;
                }
                else if (map[nr][nc] > 1) {
                    int temp = map[nr][nc];
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = ((t / temp) + 1) * temp;
                }
                else if (map[nr][nc] == 0 && t % M == 0) {
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = t;
                }
                else if (map[nr][nc] == 0 && t % M != 0) {
                    queue.offer(new Point(nr, nc));
                    visited[nr][nc] = ((t / M) + 1) * M;
                }
            }
        }

        return answer;
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_16137().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
