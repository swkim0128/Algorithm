package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_1987 extends Solution {
    @Override
    public void solution() throws IOException {
        int R, C;

        StringTokenizer token = new StringTokenizer(read.readLine(), " ");
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        char[][] board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = read.readLine();
            board[i] = str.toCharArray();
        }

        boolean[][] visited = new boolean[R][C];

        Stack<Horse> stack = new Stack<>();
        stack.push(new Horse(0, 0, board[0][0]));

//        Queue<Horse> queue = new LinkedList<>();
//        queue.offer(new Horse(0, 0, board[0][0]));

        visited[0][0] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int max = 0;
        Horse horse = null;
        while(!stack.isEmpty()) {
            horse = stack.pop();
            if (max < horse.getAlphabetNum())
                max = horse.getAlphabetNum();

            for (int i = 0; i < 4; i++) {
                int nr = horse.r + dr[i];
                int nc = horse.c + dc[i];

                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
//                if (visited[nr][nc])
//                    continue;

                if (horse.isHaveAlphabet(board[nr][nc])) {
                    continue;
                }
                else {
                    stack.push(new Horse(nr, nc, horse.alphabet, board[nr][nc]));
//                    visited[nr][nc] = true;
                }
            }
        }

        System.out.println(max);
    }

    class Horse {
        int r, c;
        int[] alphabet = new int[26];

        Horse(int r, int c, char alpha) {
            this.r = r;
            this.c = c;

            saveAlphabet(alpha);
        }

        Horse(int r, int c, int[] alpha, char ch) {
            this.r = r;
            this.c = c;

            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = alpha[i];
            }

            saveAlphabet(ch);
        }

        public void saveAlphabet(char c) {
            if (!isHaveAlphabet(c)) {
                alphabet[c - 'A']++;
            }
        }

        public boolean isHaveAlphabet(char c) {
            boolean result = false;

            if (alphabet[c - 'A'] == 0)
                result = false;
            else
                result = true;

            return result;
        }

        public int getAlphabetNum() {
            int result = 0;

            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] != 0)
                    result++;
            }

            return result;
        }

        public boolean deleteAlphabet(char c) {
            boolean result = false;

            if (isHaveAlphabet(c)) {
                alphabet[c - 'A']--;
                result = true;
            }
            else {
                result = false;
            }

            return result;
        }
    }
}
