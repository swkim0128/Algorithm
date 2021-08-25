package algorithm.baekjoon;

import algorithm.Solution;

import java.io.IOException;
import java.util.StringTokenizer;

public class baek_3985 extends Solution {
    @Override
    public void solution() throws IOException {
        int L = Integer.parseInt(read.readLine());
        int N = Integer.parseInt(read.readLine());

        StringTokenizer token;
        Customer[] customers = new Customer[N];

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(read.readLine(), " ");
            int p = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());

            customers[i] = new Customer(p, k);
        }

        int[] Lines = new int[L + 1];
        int[] customersCount = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = customers[i].p; j < customers[i].k + 1; j++) {
                if (Lines[j] == 0) {
                    Lines[j] = i + 1;
                    customersCount[i]++;
                }
            }
        }

        int expectedCustomer = 0;
        int expectedCustomerNum = 0;

        int maxCustomer = 0;
        int maxCustomerNum = 0;

        for (int i = 0; i < N; i++) {
            if (expectedCustomer < customers[i].getPieces()) {
                expectedCustomer = customers[i].getPieces();
                expectedCustomerNum = i + 1;
            }
            if (maxCustomer < customersCount[i]) {
                maxCustomer = customersCount[i];
                maxCustomerNum = i + 1;
            }
        }

        System.out.println(expectedCustomerNum);
        System.out.println(maxCustomerNum);
    }

    class Customer {
        int p, k;

        Customer(int p, int k) {
            this.p = p;
            this.k = k;
        }

        public int getPieces() {
            return k - p + 1;
        }
    }
}

