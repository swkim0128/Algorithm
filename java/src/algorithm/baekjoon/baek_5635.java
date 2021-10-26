//package algorithm.baekjoon;
//
//import algorithm.SolutionImpl;
//
//import java.util.Date;
//import java.util.Scanner;
//
//public class baek_5635 implements SolutionImpl {
//    @Override
//    public void solution() {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        String[] name = new String[n];
//        StringBuilder[] date = new StringBuilder[n];
//
//        String d, m, y;
//
//        for (int i = 0; i < n; i++) {
//            name[i] = scan.next();
//            date[i] = new StringBuilder();
//
//            d = scan.next();
//            m = scan.next();
//            y = scan.next();
//
//            date[i].append(y);
//            date[i].append(m);
//            date[i].append(d);
//
//            String temp = date[i].toString();
//            for (int j = 0; j < i; j++) {
//                if (date[j].toString() < temp) {
//                    date[j] = date[j + 1];
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(date[i].toString());
//        }
//    }
//
//}
//
//class Person implements Comparable {
//    String name;
//    String age;
//
//    @Override
//    public int compareTo(Person p) {
//        Date d1 = new Date(this.age);
//        Date d2 = new Date(p.age);
//
//        int compare = d1.compareTo(d2);
//
//        if (compare < 0) {
//            return -1;
//        }
//        else {
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }
//}
