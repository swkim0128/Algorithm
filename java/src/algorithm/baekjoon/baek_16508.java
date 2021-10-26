package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_16508 extends Solution {
    int[] res;
    String T;
    int N;

    int[] C;
    String[] W;

    int[] alphabetT = new int[26];
    int[] alphabetW = new int[26];

    int bitT = 0;

    long answer = Integer.MAX_VALUE;

    @Override
    public void solution() throws IOException {
        T = read.readLine();
        N = Integer.parseInt(read.readLine());

        /*
            비트마스터 비교 방법.
         */

        for (int i = 0; i < T.length(); i++) {
            bitT |= 1 << (T.charAt(i) - 'A');
        }

        /*
            알파벳으로 비교하기.
         */
//        char[] temp = T.toCharArray();
//        for (int i = 0; i < temp.length; i++) {
//            alphabetT[temp[i] - 'A']++;
//        }

        C = new int[N];
        W = new String[N];
        StringTokenizer token;

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            C[i] = Integer.parseInt(token.nextToken());
            W[i] = token.nextToken();
        }

        int total = 1 << N;
        for (int i = 1; i < total; i++) {
            int tempResult = bitT;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) == 0) continue;

                for (int k = 0; k < W[j].length(); k++) {
                    int temp = 1 << (W[j].charAt(k) - 'A');
                    temp = ~temp;
                    tempResult &= temp;
                }
                sum += C[j];

                if (tempResult == 0) {
                    if (answer > sum) {
                        answer = sum;
//                        breaik;
                    }
                }
            }
        }

//        generateSubSet(0, 0);

//        if (isContain()) {
//            for (int i = 0; i < N - 1; i++) {
//                res = new int[i + 1];
//                combination(i + 1, 0, 0);
//            }
//        }
//        else {
//            answer = -1;
//        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public void generateSubSet(int n, int total) {
        if (n == N) {
            if (isEquals()) {
                if (answer > total) {
                    answer = total;
                }
            }

            return ;
        }
        else {
//            char[] temp = W[n].toCharArray();

            /*
                비트마스터 사용하기
             */
            /*
                알파벳 배열로 비교하는 방법.
             */
//            for (int i = 0; i < temp.length; i++) {
//                alphabetW[temp[i] - 'A']++;
//            }
            generateSubSet(n + 1, total + C[n]);
            /*
                비트마스터 사용하기
             */
            /*
                알파벳 배열로 비교하는 방법.
             */
//            for (int i = 0; i < temp.length; i++) {
//                alphabetW[temp[i] - 'A']--;
//            }
            generateSubSet(n + 1, total);
        }
    }

    public boolean isEquals() {
        boolean result = true;
        /*
            비트 마스터 방법
         */
        int tempResult = bitT;
        for (int i = 0; i < N; i++) {
                for (int j = 0; j < W[i].length(); j++) {
                    int temp = 1 << (W[i].charAt(j) - 'A');
                    temp = ~temp;
                    tempResult = tempResult & temp;
                    System.out.println(Integer.toBinaryString(tempResult));

                    if (tempResult == 0) {
                        return true;
                    }
                }
        }

        return false;
        /*
            알파벳 배열방법
         */
//        for (int i = 0; i < 26; i++) {
//            if (alphabetT[i] > alphabetW[i]) {
//                result = false;
//                break;
//            }
//        }

//        return result;
    }

    public boolean isContain() {
        char[] tempT = T.toCharArray();

        for (int i = 0; i < N; i++) {
            char[] tempW = W[i].toCharArray();

            for (int j = 0; j < tempT.length; j++) {
                for (int k = 0; k < tempW.length; k++) {
                    if (tempT[j] == tempW[k]) {
                        tempT[j] = ' ';
                        break;
                    }
                }
            }
        }

        boolean result = true;
        for (int i = 0; i < tempT.length; i++) {
            if (tempT[i] != ' ') {
                result = false;
                break;
            }
        }

        return result;
    }

    public void combination(int n, int cnt, int start) {
        if (cnt == n) {
//            char[] tempT = T.toCharArray();
//
//            for (int i = 0; i < res.length; i++) {
//                char[] tempW = W[res[i]].toCharArray();
//
//                for (int j = 0; j < tempT.length; j++) {
//                    if (tempT[j] == ' ') continue;
//
//                    for (int k = 0; k < tempW.length; k++) {
//                        if (tempW[k] == ' ') continue;
//                        if (tempT[j] == tempW[k]) {
//                            tempT[j] = ' ';
//                            tempW[k] = ' ';
//                            break;
//                        }
//                    }
//                }
//            }
//
//            boolean isTempT = true;
//            for (int i = 0; i < tempT.length; i++) {
//                if (tempT[i] != ' ') {
//                    isTempT = false;
//                    break;
//                }
//            }
//
//            if (isTempT) {
//                long sum = 0;
//                for (int i = 0; i < res.length; i++) {
//                    sum += C[res[i]];
//                }
//
//                if (answer > sum) {
//                    answer = sum;
//                }
//            }

            boolean isCompleted = true;
            for (int j = 0; j < 26; j++) {
                if (alphabetT[j] > alphabetW[j]) {
                    isCompleted = false;
                    break;
                }
            }

            if (isCompleted) {
                int sum = 0;
                for (int j = 0; j < res.length; j++) {
                    sum += C[res[j]];
                }

                if (answer > sum) {
                    answer = sum;
                }
            }

            return;
        }

        for (int i = start; i < N; i++) {
            res[cnt] = i;

            char[] temp = W[i].toCharArray();

            for (int j = 0; j < temp.length; j++) {
                alphabetW[temp[j] - 'A']++;
            }
            combination(n, cnt + 1, ++start);
            for (int j = 0; j < temp.length; j++) {
                alphabetW[temp[j] - 'A']--;
            }
        }
    }
}
