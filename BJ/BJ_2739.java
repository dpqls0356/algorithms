package BJ;

import java.util.Scanner;

public class BJ_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", T, i, T * i);
        }
    }
}
