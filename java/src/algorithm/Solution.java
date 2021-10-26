package algorithm;

import java.io.*;
import java.util.Scanner;

public abstract class Solution implements SolutionImpl {
    protected Scanner scan;
    protected BufferedReader read;

    protected BufferedWriter write;

    {
        try {
            System.setIn(new FileInputStream("src/algorithm/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scan = new Scanner(System.in);
        read = new BufferedReader(new InputStreamReader(System.in));

        write = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public abstract void solution() throws IOException;
}
