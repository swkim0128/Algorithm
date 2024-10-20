package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class baek_4779 extends Main {

    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        while (read.ready()) {
            int N = Integer.parseInt(read.readLine());

            List<char[]> dynamicArr = new ArrayList<>();

            int indexSize = 1;
            for (int i = 0; i < N + 1; i++) {
                char[] tempArr = new char[indexSize];

                if (i == 0) {
                    tempArr[0] = '-';
                }
                else if (i == 1) {
                    tempArr[0] = '-';
                    tempArr[1] = ' ';
                    tempArr[2] = '-';
                }
                else {
                    for (int k = 0; k < indexSize / 3; k++) {
                        tempArr[k] = dynamicArr.get(i - 1)[k];
                    }

                    for (int k = 0; k < indexSize / 3; k++) {
                        tempArr[1 * (indexSize / 3) + k] = ' ';
                    }

                    for (int k = 0; k < indexSize / 3; k++) {
                        tempArr[2 * (indexSize / 3) + k] = dynamicArr.get(i - 1)[k];
                    }
                }

                dynamicArr.add(tempArr);
                indexSize *= 3;
            }

            System.out.println(dynamicArr.get(dynamicArr.size() - 1));
        }
    }
    static {
        try {
            new baek_4779().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
