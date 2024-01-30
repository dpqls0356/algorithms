package BJ;

import java.util.Scanner;

public class BJ2750 {
    // sort, 우선순위큐도 사용가능하나 버블정렬 공부용...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] arr = new int[tc];
        for (int i = 0; i < tc; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < tc - 1; i++) {
            // 루프가 돈 만큼 비교할 연산 수가 줄어들어 -i를 추가
            for (int k = 0; k < tc - i - 1; k++) {
                if (arr[k + 1] < arr[k]) {
                    int swap = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = swap;
                }
            }
        }
        for (int i = 0; i < tc; i++)
            System.out.println(arr[i]);
    }
}
