package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek_12933 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // input
        String s = read.readLine();

        // algo
        ArrayList<String> quack = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            // q -> u -> a -> c -> k
            if (quack.isEmpty() && s.charAt(i) != 'q') {
                break;
            }
            if (quack.isEmpty() && s.charAt(i) == 'q') {
                quack.add(String.valueOf(s.charAt(i)));
                visited[i] = true;
                continue;
            }

            for (int j = 0; j < quack.size(); j++) {
                String tmp = quack.get(j);
                if (tmp.charAt(tmp.length() - 1) == 'q' && s.charAt(i) == 'u') {
                    tmp += "u";
                    quack.set(j, tmp);
                    visited[i] = true;
                    break;
                }
                else if (tmp.charAt(tmp.length() - 1) == 'u' && s.charAt(i) == 'a') {
                    tmp += "a";
                    quack.set(j, tmp);
                    visited[i] = true;
                    break;
                }
                else if (tmp.charAt(tmp.length() - 1) == 'a' && s.charAt(i) == 'c') {
                    tmp += "c";
                    quack.set(j, tmp);
                    visited[i] = true;
                    break;
                }
                else if (tmp.charAt(tmp.length() - 1) == 'c' && s.charAt(i) == 'k') {
                    tmp += "k";
                    quack.set(j, tmp);
                    visited[i] = true;
                    break;
                }
                else if (tmp.charAt(tmp.length() - 1) == 'k' && s.charAt(i) == 'q') {
                    tmp += "q";
                    quack.set(j, tmp);
                    visited[i] = true;
                    break;
                }
            }

            if (!visited[i] && s.charAt(i) == 'q') {
                quack.add(String.valueOf(s.charAt(i)));
                visited[i] = true;
            }
        }

        for (boolean b : visited) {
            if (!b) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(quack.size());
    }

    static {
        try {
            new baek_12933().run();
        }
        catch (IOException e) {

        }
    }
    static {
        try {
            new baek_12933().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
