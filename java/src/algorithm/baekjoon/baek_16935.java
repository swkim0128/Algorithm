package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_16935 extends Solution {
    int N, M;

    @Override
    public void solution() throws IOException {
        int R;
        StringTokenizer token = new StringTokenizer(read.readLine(), " ");

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int[] order = new int[R];
        token = new StringTokenizer(read.readLine(), " ");
        for (int i = 0; i < R; i++) {
            order[i] = Integer.parseInt(token.nextToken());
        }

        for (int i = 0; i < R; i++) {
            switch (order[i]) {
                case 1:
                    arr = orderOne(arr);
                    break;
                case 2:
                    arr = orderTwo(arr);
                    break;
                case 3:
                    arr = orderThree(arr);
                    break;
                case 4:
                    arr = orderFour(arr);
                    break;
                case 5:
                    arr = orderFive(arr);
                    break;
                case 6:
                    arr = orderSix(arr);
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] orderOne(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[N - i - 1][j] = arr[i][j];
            }
        }

        return result;
    }

    public int[][] orderTwo(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][M - j - 1] = arr[i][j];
            }
        }

        return result;
    }

    public int[][] orderThree(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[j][N - 1 - i] = arr[i][j];
            }
        }

        return result;
    }

    public int[][] orderFour(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[M - 1 - j][i] = arr[i][j];
            }
        }

        return result;
    }

    public int[][] orderFive(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[i][M / 2 + j] = arr[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[i][j] = arr[N / 2 + i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                result[N / 2 + i][j] = arr[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[i][j] = arr[i][M / 2 + j];
            }
        }

        return result;
    }

    public int[][] orderSix(int[][] arr) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] result = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[N / 2 + i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[i][j] = arr[i][M / 2 + j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                result[i][j] = arr[N / 2 + i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                result[i][M / 2 + j] = arr[i][j];
            }
        }

        return result;
    }
}
