package BJ;

import java.util.Scanner;

public class BJ_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N값 입력받기
        int N = sc.nextInt();

        // 반복문을 이용해 별 찍기
        for (int i = 0; i < N; i++) {
            for (int j = N - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 반복문을 이용해 별 찍기
        for (int k = N - 1; k > 0; k--) {
            for (int j = 1; j < N - k + 1; j++) {
                System.out.print(" ");
            }
            for (int i = k * 2 - 1; i > 0; i--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
