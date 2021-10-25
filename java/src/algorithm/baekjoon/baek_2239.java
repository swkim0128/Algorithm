package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;

public class baek_2239 extends Solution {
    final int SUDOKU = 9;

    int[][] map;
    ArrayList<Point> list = new ArrayList<>();

    boolean[][] width = new boolean[SUDOKU][SUDOKU + 1];
    boolean[][] height = new boolean[SUDOKU][SUDOKU + 1];
    boolean[][] squre = new boolean[SUDOKU][SUDOKU + 1];

    @Override
    public void solution() throws IOException {
        map = new int[SUDOKU][SUDOKU];

        for (int i = 0; i < SUDOKU; i++) {
            char[] ch = read.readLine().toCharArray();
            for (int j = 0; j < SUDOKU; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        addList();
        findSudoku(0);

        for (int i = 0; i < SUDOKU; i++) {
            for (int j = 0; j < SUDOKU; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void addList() {
        for (int i = 0; i < SUDOKU; i++) {
            for (int j = 0; j < SUDOKU; j++) {
                if (map[i][j] == 0)
                    list.add(new Point(i, j));
                else {
                    int n = map[i][j];

                    width[i][n] = true;
                    height[j][n] = true;

                    int row = (i / 3) * 3 + j / 3;
                    squre[row][n] = true;
                }
            }
        }
    }

    boolean complete = false;

    public void findSudoku(int cnt) {
        if (complete)
            return;

        if (cnt == list.size()) {
            if (isComplete())
                complete = true;
            return;
        }

        Point p = list.get(cnt);
        int r = p.r, c = p.c;

        for (int i = 1; i < SUDOKU + 1; i++) {
            map[r][c] = i;

            if (isSUDOKU(p, i)) {
                setVisited(p, i, true);
                findSudoku(cnt + 1);
                setVisited(p, i, false);
            }
            if (complete)
                return;
        }
    }

    public boolean isComplete() {
        for (int i = 0; i < SUDOKU; i++) {
            for (int j = 1; j < SUDOKU + 1; j++) {
                if (!width[i][j])
                    return false;
                if (!height[i][j])
                    return false;
                if (!squre[i][j])
                    return false;
            }
        }

        return true;
    }

    public boolean isSUDOKU(Point p, int n) {
        int r = p.r, c = p.c;
        if (width[r][n])
            return false;
        if (height[c][n])
            return false;

        int row = (r / 3) * 3 + c / 3;
        if (squre[row][n])
            return false;

        return true;
    }

    public void setVisited(Point p, int n, boolean v) {
        int r = p.r, c = p.c;
        int row = (r / 3) * 3 + c / 3;

        width[r][n] = v;
        height[c][n] = v;
        squre[row][n] = v;
    }

    class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
