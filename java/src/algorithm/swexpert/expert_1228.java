package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class expert_1228 extends Solution {
    @Override
    public void solution() throws IOException {

        for (int t = 0; t < 10; t++) {
            int N = Integer.parseInt(read.readLine());
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");
            LinkedList<Integer> list = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(token.nextToken()));
            }

            int order = Integer.parseInt(read.readLine());
            token = new StringTokenizer(read.readLine(), " ");

            for (int i = 0; i < order; i++) {
                String o = token.nextToken();
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());

                switch (o) {
                    case "I":
                        for (int j = 0; j < y; j++) {
                            list.add(x + j, Integer.parseInt(token.nextToken()));
                        }
                        break;
                    case "D":
                        for (int j = 0; j < y; j++) {
                            list.remove(x);
                        }
                        break;
                }

            }

            System.out.print("#" + (t + 1) + " ");

            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
