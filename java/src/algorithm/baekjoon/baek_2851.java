package algorithm.baekjoon;

import algorithm.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_2851 extends Main {
    @Override
    public void run() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));        final int SIZE = 10;
        Scanner scan = new Scanner(System.in);
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
    static {
        try {
            new baek_2851().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
