package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16236 extends Main {
    int N;
    int[][] map;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        N = Integer.parseInt(read.readLine());

        map = new int[N][N];
        BabyShark baby = null;

        StringTokenizer token;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(token.nextToken());

                if (map[i][j] == 9)
                    baby = new BabyShark(i, j);
            }
        }

        int answer = yammi(baby);

        System.out.println(answer);
    }

    boolean isCalledMommy = false;

    public int yammi(BabyShark baby) {
        int answer = 0;

        while (true) {
            if (isCalledMommy)
                break;

            answer += moveSimulation(baby);
        }

        return answer;
    }

    public int moveSimulation(BabyShark baby) {
        ArrayList<Data> list = baby.findFoodList(map);
        int[][] visited = bfs(baby);

        if (list.size() == 0) {
            isCalledMommy = true;
            return 0;
        }

        int count = Integer.MAX_VALUE;
        int index = 0;

        isCalledMommy = true;
        for (int i = 0; i < list.size(); i++) {
            int row, column;
            row = list.get(i).r;
            column = list.get(i).c;

            if (visited[row][column] != 0) {
                isCalledMommy = false;

                int c = visited[row][column] - 1;
                if (count > c) {
                    count = c;
                    index = i;
                }
            }
        }

        if (isCalledMommy)
            return 0;

        int row = list.get(index).r;
        int column = list.get(index).c;

        map[row][column] = 9;
        map[baby.r][baby.c] = 0;
        baby.eat(row, column);

        return count;
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int[][] bfs(BabyShark baby) {
        int[][] visited = new int[N][N];

        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(baby.r, baby.c));
        visited[baby.r][baby.c] = 1;

        Data d = null;
        while (!queue.isEmpty()) {
            d = queue.poll();

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = d.r + dr[i];
                nc = d.c + dc[i];

                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (map[nr][nc] > baby.size)
                    continue;
                if (visited[nr][nc] != 0)
                    continue;

                queue.offer(new Data(nr, nc));
                visited[nr][nc] = visited[d.r][d.c] + 1;
            }
        }

        return visited;
    }

    class BabyShark {
        int r, c;
        int size = 2;
        int count;

        BabyShark(int r, int c) {
            this.r = r;
            this.c = c;
            size = 2;
            count = 0;
        }

        public ArrayList<Data> findFoodList(int[][] arr) {
            ArrayList<Data> list = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] < size && arr[i][j] != 0) {
                        list.add(new Data(i, j));
                    }
                }
            }

            return list;
        }

        public void eat(int r, int c) {
            this.r = r;
            this.c = c;
            count++;

            isSize();
        }

        public void isSize() {
            if (count == size) {
                size++;
                count = 0;
            }
        }
    }

    class Data {
        int r, c;

        Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static {
        try {
            new baek_16236().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
