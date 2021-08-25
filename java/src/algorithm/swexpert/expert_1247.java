package algorithm.swexpert;

import algorithm.Main;
import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class expert_1247 extends Solution {
    int N = 0;

    House home;
    House[] customer;
    boolean[] visited;

    int result;
    int tempAnswer = 0;

    @Override
    public void solution() throws IOException {
        int testCase = Integer.parseInt(read.readLine());
        int[] answer = new int[testCase];

        for (int t = 0; t < testCase; t++) {
            N = Integer.parseInt(read.readLine());

            House office;
            customer = new House[N];
            visited = new boolean[N];

            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            int x, y;

            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());
            office = new House(x, y);

            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());
            home = new House(x, y);

            for (int i = 0; i < N; i++) {
                x = Integer.parseInt(token.nextToken());
                y = Integer.parseInt(token.nextToken());

                customer[i] = new House(x, y);
            }

            result = Integer.MAX_VALUE;
            perm(0, office.x, office.y, 0);
//            dfs(0, office.x, office.y);

//            int[] numbers = new int[N];
//            for (int i = N - 1; i >= 0; i--) {
//                numbers[i] = i;
//            }
//
//            int result = Integer.MAX_VALUE;
//            do {
//                int nowX, nowY;
//
//                nowX = office.x;
//                nowY = office.y;
//
//                int sum = 0;
//                for (int i = 0; i < N; i++) {
//                    sum += customer[numbers[i]].getDistance(nowX, nowY);
//                    nowX = customer[numbers[i]].x;
//                    nowY = customer[numbers[i]].y;
//
//                    if (result < sum)
//                        break;
//                }
//
//                sum += home.getDistance(nowX, nowY);
//
//                if (result > sum) {
//                    result = sum;
//                }
//            } while (np(numbers));

            answer[t] = result;
            result = Integer.MAX_VALUE;
        }

        for (int t = 0; t < testCase; t++) {
            System.out.println("#" + (t + 1) + " " + answer[t]);
        }
    }

    public void perm(int cnt, int x, int y, int amount) {
        if (result < amount)
            return;
        if (cnt == N) {
            amount += home.getDistance(x, y);

            if (result > amount)
                result = amount;

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int d = customer[i].getDistance(x, y);
            perm(cnt + 1, customer[i].x, customer[i].y, amount + d);
            visited[i] = false;
        }
    }

    public void dfs(int cnt, int x, int y) {
        if (cnt == N) {
            tempAnswer += home.getDistance(x, y);
            return;
        }

        int result = Integer.MAX_VALUE;
        int resultIndex = 0;
        int d = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            d = customer[i].getDistance(x, y);

            if (result > d) {
                result = d;
                resultIndex = i;
            }
        }

        tempAnswer += result;
        visited[resultIndex] = true;
        dfs(cnt + 1, customer[resultIndex].x, customer[resultIndex].y);
    }

    public boolean np(int[] numbers) {
        int N = numbers.length;

        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i])
            i--;

        if (i == 0)
            return false;

        int j = N - 1;
        while (numbers[i- 1] >= numbers[j])
            j--;

        swap(numbers, i - 1, j);

        int k = N - 1;
        while(i < k) {
            swap(numbers, i, k);
            i++;
            k--;
        }

        return true;
    }

    public void swap(int[] numbers, int i , int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    class House {
        int x, y;

        House(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(int x, int y) {
            return Math.abs(this.x - x) + Math.abs(this.y - y);
        }
    }
}
