package algorithm.swexpert;

import algorithm.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class expert_8458 extends Solution {
    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());

        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(read.readLine());

            ArrayList<Data> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int x, y;

                StringTokenizer token = new StringTokenizer(read.readLine(), " ");
                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());

                list.add(new Data(x, y));
            }

            int d = list.get(0).d;
            boolean isGo = true;
            for (int i = 1; i < N; i++) {
                if (d % 2 != list.get(i).d % 2) {
                    isGo = false;
                    break;
                }
                d = Math.max(d, list.get(i).d);
            }

            int answer = -1;
            if (!isGo) {
                System.out.println("#" + (t + 1) + " " + answer);
                continue;
            }

            int dSum = 0;
            int cnt = 0;
            while (true) {
                if (d == dSum) {
                    answer = cnt;
                    break;
                }
                if (d < dSum) {
                    dSum -= cnt;
                    break;
                }
                cnt++;
                dSum += cnt;
            }


            if (d == dSum) {
                answer = cnt;
            }
            else if ((d - dSum) % 2 == 0) {
                if (cnt % 2 == 0) {
                    answer = cnt;
                }
                else {
                    answer = cnt + 2;
                }
            }
            else {
                if (cnt % 2 == 0) {
                    answer = cnt + 1;
                }
                else {
                    answer = cnt;
                }
            }

            System.out.println("#" + (t + 1) + " " + answer);
        }
    }

    class Data {
        int x, y;
        int d;

        Data(int x, int y) {
            this.x = x;
            this.y = y;

            getDistance();
        }

        public int getDistance() {
            return d = Math.abs(x) + Math.abs(y);
        }
    }
}
