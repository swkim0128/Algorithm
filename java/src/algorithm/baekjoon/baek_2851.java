package algorithm.baekjoon;

import algorithm.Main;
import algorithm.Solution;

import java.io.IOException;

public class baek_2851 extends Solution {
    @Override
    public void solution() throws IOException {
        final int SIZE = 10;
        int[] mushroom = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            mushroom[i] = scan.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < SIZE; i++) {
            if (sum + mushroom[i] < 100) {
                sum += mushroom[i];
            }
            else if (sum + mushroom[i] == 100){
                sum += mushroom[i];
                break;
            }
            else {
                if (Math.abs(100 - sum) == Math.abs(100 - (sum + mushroom[i]))) {
                    sum += mushroom[i];
                    break;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
