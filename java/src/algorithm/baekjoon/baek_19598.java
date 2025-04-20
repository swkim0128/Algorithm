package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek_19598 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int[][] arr;

        N = Integer.parseInt(read.readLine());

        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        // 시작 시간, 종료 시간이 겹치면 새로운 회의실 필요
        // 종료 시간이 끝난 회의실이 있으면 사용 가능
        List<Integer> room = new ArrayList<>();
        room.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            boolean isAdded = false;
            for (int j = 0; j < room.size(); j++) {
                // 시작 시간이 종료시간과 같거나 그 뒤면 새로운 것으로 교체
                int endTime = room.get(j);
                if (endTime <= arr[i][0]) {
                    room.add(j, arr[i][1]);
                    room.remove(j);
                    isAdded = true;
                    break;
                }
            }

            if (!isAdded) {
                room.add(arr[i][1]);
            }
        }

        System.out.println(room.size());
    }

    static {
        try {
            new baek_19598().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
