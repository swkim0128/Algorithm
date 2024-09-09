package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baek_14594 extends Solution {
    @Override
    public void solution() throws IOException {
        // input
        int N;
        int M;

        N = Integer.parseInt(read.readLine());
        M = Integer.parseInt(read.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            int x, y;
            x = Integer.parseInt(token.nextToken());
            y = Integer.parseInt(token.nextToken());

            map.put(x, y);
        }

        // algo
        // 맨 왼쪽 방의 번호는 1번이며, 순서대로 증가하여 맨 오른쪽 방의 번호가 N번이다. 각 방 사이에는 방을 구분하는 벽이 존재한다.

        // 빅-종빈빌런이 나타나 건물 벽을 허물기 시작한 것이다! 빅-종빈빌런은 다음과 같은 규칙으로 벽을 무너뜨린다.
        //
        // x < y 를 만족하는 두 방에 대해서 x번 방부터 y번 방 사이에 있는 모든 벽을 허문다.
        // 두 방 사이의 벽이 허물어지면 두 방은 하나의 방으로 합쳐진다.
        // 이미 허물어진 벽이 존재한다면 무시하고 다음 벽을 허문다.
        // 빅-종빈빌런은 건물이 무너지는 걸 원치 않기 때문에, 1번 방의 왼쪽 벽과 N번 방의 오른쪽 벽(즉, 바깥과 연결된 벽)은 허물지 않는다.

        int[] arr = new int[N + 1];

        map.forEach((x, y) -> {
           for (int i = x; i < y; i++) {
               arr[i] = 1;
           }
        });

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 0) {
                result++;
            }
        }

        System.out.println(result);
    }
}
