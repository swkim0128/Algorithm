package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class baek_2232 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        // input
        int N;
        int[] arr = null;

        N = Integer.parseInt(read.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(read.readLine());
        }

        int resultCnt = 999999;
        List<Integer> results = new ArrayList<>();

        // algo
        int count = 1 << N;
        for (int i = 0; i < count; i++) {
            ArrayList<Integer> idxs = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    idxs.add(j);
                }
            }

            boolean isComplete = confirm(arr, idxs);

            if (isComplete && idxs.size() <= resultCnt) {
                results = idxs.stream().sorted().collect(Collectors.toList());
            }
        }

        for (Integer r : results) {
            System.out.println(r + 1);
        }
    }

    public static boolean confirm(int[] arr, ArrayList<Integer> idxs) {
        int size = arr.length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isBomb = new boolean[size];

        for (Integer idx : idxs) {
            queue.add(idx);
            isBomb[idx] = true;
        }

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            int bmCnt = arr[tmp];
            if (tmp + 1 < size && !isBomb[tmp + 1] && arr[tmp + 1] < bmCnt) {
                queue.add(tmp + 1);
                isBomb[tmp + 1] = true;
            }
            if (0 <= tmp - 1 && !isBomb[tmp - 1] && arr[tmp - 1] < bmCnt) {
                queue.add(tmp - 1);
                isBomb[tmp - 1] = true;
            }
        }

        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            if (!isBomb[i]) {
                result = false;
            }
        }

        return result;
    }
    static {
        try {
            new baek_2232().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
