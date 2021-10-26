package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class expert_4014 extends Solution {
    int N, X;
    int[][] map;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            N = Integer.parseInt(token.nextToken());
            X = Integer.parseInt(token.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(read.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }

            int answer = search();
            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    public int search() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (searchRow(i))
                cnt++;
            if (searchCol(i))
                cnt++;
        }

        return cnt;
    }

    public boolean searchRow(int row) {
        int cnt = 1;

        ArrayList<Integer> tilt = new ArrayList<>();
        ArrayList<Integer> leng = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int temp = map[row][i] - map[row][i + 1];

            if (Math.abs(temp) > 1)
                return false;
            if (temp == 0) {
                cnt++;
            }
            else {
                tilt.add(temp);
                leng.add(cnt);
                cnt = 1;
            }
        }

        leng.add(cnt);

        boolean result = true;
        if (tilt.size() == 0) {
            result = true;
        }
        else if (tilt.size() == 1) {
            int t = tilt.get(0);
            if (t < 0 && leng.get(0) >= X)
                result = true;
            else if (t > 0 && leng.get(1) >= X)
                result = true;
            else
                result = false;
        }
        else {
            for (int i = 0; i < tilt.size(); i++) {
                int t = tilt.get(i);
                int prev = leng.get(i);
                int next = leng.get(i + 1);

                if (t < 0 && prev >= X)
                    result = true;
                else if (t > 0 && next >= X)
                    result = true;
                else {
                    result = false;
                    break;
                }

                if (i > 0 && tilt.get(i - 1) < 0 && t > 0) {
                    if (leng.get(i - 1) >= X && next >= X)
                        result = true;
                    else {
                        result = false;
                        break;
                    }
                }
                else if (i > 0 && tilt.get(i - 1) > 0 && t < 0) {
                    if (prev >= X * 2)
                        result = true;
                    else {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }

    public boolean searchCol(int col) {
        int cnt = 1;
        int n = 0;

        ArrayList<Integer> tilt = new ArrayList<>();
        ArrayList<Integer> leng = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int temp = map[i][col] - map[i + 1][col];

            if (Math.abs(temp) > 1)
                return false;
            if (temp == 0) {
                cnt++;
            }
            else {
                tilt.add(temp);
                leng.add(cnt);
                cnt = 1;
            }
        }

        leng.add(cnt);

        boolean result = true;
        if (tilt.size() == 0) {
            result = true;
        }
        else if (tilt.size() == 1) {
            int t = tilt.get(0);
            if (t < 0 && leng.get(0) >= X)
                result = true;
            else if (t > 0 && leng.get(1) >= X)
                result = true;
            else
                result = false;
        }
        else {
            for (int i = 0; i < tilt.size(); i++) {
                int t = tilt.get(i);
                int prev = leng.get(i);
                int next = leng.get(i + 1);

                if (t < 0 && prev >= X)
                    result = true;
                else if (t > 0 && next >= X)
                    result = true;
                else {
                    result = false;
                    break;
                }

                if (i > 0 && tilt.get(i - 1) < 0 && t > 0) {
                    if (leng.get(i - 1) >= X && next >= X)
                        result = true;
                    else {
                        result = false;
                        break;
                    }
                }
                else if (i > 0 && tilt.get(i - 1) > 0 && t < 0) {
                    if (prev >= X * 2)
                        result = true;
                    else {
                        result = false;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
