package algorithm.baekjoon;

import algorithm.SolutionImpl;

import java.util.Arrays;
import java.util.Scanner;

public class baek_7600 implements SolutionImpl {
    public void solution() {
        Scanner scan = new Scanner(System.in);
        boolean[] visited = new boolean[26];

        while (true) {
            String str = scan.nextLine();
            str = str.toUpperCase();

            if (str.charAt(0) == '#') {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                int c = (int)str.charAt(i) - 65;

                if (0 <= c && c < 26) {
                    if (visited[c]) {
                        continue;
                    } else {
                        visited[c] = true;
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    answer++;
                }
            }
            Arrays.fill(visited, false);
            System.out.println(answer);
        }
    }
}
