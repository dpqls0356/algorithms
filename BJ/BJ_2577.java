package BJ;

import java.util.Scanner;

public class BJ_2577 {
    public static void main(String[] args) {

        // BJ_2577
        // 주석 작성자 : 이예빈
        // 결과 메모리 시간 길이
        // 맞았습니다!! 17676kb 204ms 511b
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        String res = String.valueOf(A * B * C);
        int arr[] = new int[10];
        for (int i = 0; i < res.length(); i++) {
            arr[res.charAt(i) - '0']++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
