package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15683 extends Main {
    int N, M;
    char[][] map;

    CCTV[] cctvs;
    int cctvSize = 0;

    int answer = 0;

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = token.nextToken().charAt(0);
            }
        }

        cctvs = new CCTV[N * M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#')
                    continue;
                if (map[i][j] == '0') {
                    answer++;
                    continue;
                }
                if (map[i][j] == '6')
                    continue;
                if (map[i][j] == '5') {
                    setArea5(map, i, j);
                    continue;
                }
                cctvs[cctvSize] = new CCTV(i, j, map[i][j] - '0');
                cctvSize++;
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    public void dfs(int cnt, char[][] map) {
        if (cnt == cctvSize) {
            int blind = getBlindArea(map);

            if (answer > blind) {
                answer = blind;
            }

            return;
        }

        char[][] tempMap;

        switch (cctvs[cnt].type) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    tempMap = setArea1(map, cctvs[cnt].r, cctvs[cnt].c, i);
                    dfs(cnt + 1, tempMap);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    tempMap = setArea2(map, cctvs[cnt].r, cctvs[cnt].c, i);
                    dfs(cnt + 1, tempMap);
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    tempMap = setArea3(map, cctvs[cnt].r, cctvs[cnt].c, i);
                    dfs(cnt + 1, tempMap);
                }
                break;
            case 4:
                for (int i = 0; i < 2; i++) {
                    tempMap = setArea4(map, cctvs[cnt].r, cctvs[cnt].c, i);
                    dfs(cnt + 1, tempMap);
                }
                break;
        }
    }

    public int getBlindArea(char[][] map) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0')
                    result++;
            }
        }

        return result;
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public char[][] setArea1(char[][] map, int r, int c, int d) {
        char[][] tempMap = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        setArea(tempMap, r, c, d);
        return tempMap;
    }

    public char[][] setArea2(char[][] map, int r, int c, int d) {
        char[][] tempMap = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        switch (d) {
            case 0:
                setArea(tempMap, r, c, 0);
                setArea(tempMap, r, c, 2);
                break;
            case 1:
                setArea(tempMap, r, c, 1);
                setArea(tempMap, r, c, 3);
                break;
        }
        return tempMap;
    }

    public char[][] setArea3(char[][] map, int r, int c, int d) {
        char[][] tempMap = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        switch (d) {
            case 0:
                setArea(tempMap, r, c, 0);
                setArea(tempMap, r, c, 1);
                break;
            case 1:
                setArea(tempMap, r, c, 1);
                setArea(tempMap, r, c, 2);
                break;
            case 2:
                setArea(tempMap, r, c, 2);
                setArea(tempMap, r, c, 3);
                break;
            case 3:
                setArea(tempMap, r, c, 3);
                setArea(tempMap, r, c, 0);
                break;
        }
        return tempMap;
    }

    public char[][] setArea4(char[][] map, int r, int c, int d) {
        char[][] tempMap = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        setArea(tempMap, r, c, 1);
        setArea(tempMap, r, c, 3);

        switch (d) {
            case 0:
                setArea(tempMap, r, c, 0);
                break;
            case 1:
                setArea(tempMap, r, c, 2);
                break;
        }

        return tempMap;
    }

    public int setArea5(char[][] tempMap, int r, int c) {
        setArea(tempMap, r, c, 0);
        setArea(tempMap, r, c, 1);
        setArea(tempMap, r, c, 2);
        setArea(tempMap, r, c, 3);

        return 0;
    }

    public void setArea(char[][] map, int r, int c, int d) {
        Direction direction = new Direction(r, c);
        int nr, nc;

        while (true) {
            nr = direction.r + dr[d];
            nc = direction.c + dc[d];

            if (nr < 0 || N <= nr || nc < 0 || M <= nc) break;
            if (map[nr][nc] == '6') break;
            if (map[nr][nc] == '0') {
                map[nr][nc] = '#';
            }

            direction.r = nr;
            direction.c = nc;
        }
    }

    class Direction {
        int r, c;

        Direction(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
    class CCTV {
        int r, c;
        int type;

        CCTV(int r, int c, int type) {
            this.r = r;
            this.c = c;
            this.type = type;
        }

        public void setWatchArea(int[][] map, int d) {
            switch (type) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }
    }
    static {
        try {
            new baek_15683().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
