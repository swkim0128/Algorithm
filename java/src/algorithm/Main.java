package algorithm;

import algorithm.baekjoon.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
    }

    static {
        try {
            System.setIn(new FileInputStream("src/algorithm/input.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {}
}
