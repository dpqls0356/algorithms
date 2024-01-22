package BJ;

import java.util.Scanner;

public class BJ_10870 {
    public static void main(String args[]) {
        /**
         * BJ_10870
         * 작성자 : 이예빈
         * 제출 : 2024.01.22
         * 결과 : 맞았습니다!!
         * 성능 요약 : 메모리 17652kb, 시간 204 ms, 길이 288b
         * 
         * 접근법
         * > front(f) = 0 , back(b) = 1로 시작해서
         * > T==0일땐 b울 0으로 바꾸기 => b이 구하려는 n번째의 파보니치 수라서
         * > 반복문을 2부터 T까지 반복하며 n번째 파보니치 수 구해나가기
         * 
         */

        // 입력을 받기위한 변수 선언 및 생성, 할당
        Scanner sc = new Scanner(System.in);
        // 구하고싶은 N번째 파보니치 수 입력받기
        int T = sc.nextInt();
        // 0번째 파보니치 수
        int f = 0;
        // 1번째 파보니치 수
        int b = 1;
        // 구하려는 파보니치 수가 0번째라면 b를 1로 변경
        if (T == 0)
            b = 0;
        // N번째 파보니치 수 구하기
        for (int i = 2; i <= T; i++) {
            // N번째의 수를 swap넣기
            int swap = b;
            // 변경될 N= N+N-1
            b += f;
            // 변경될 N-1 = N값 넣기
            f = swap;
        }
        System.out.print(b);
    }
}
