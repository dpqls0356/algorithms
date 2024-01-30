package BJ;

import java.util.Scanner;

public class BJ_27433 {
    /**
     * BJ_27433
     * 작성자 : 이예빈
     * 제출 : 2024.01.21 ~ 22
     * 결과 : 맞았습니다!!
     * 성능 요약 : 메모리 17688 kb, 시간 200 ms, 길이 364 b
     * 
     * 접근법
     * > N*N-1*(N-1)-1*...
     * > 한번에 통과가 안되었는데 n이 0일때를 고려안했기때문
     * -> n이 1과 같거나 작으면 1리턴하는 것으로 고침
     */
    public static void main(String[] args) {
        // 입력을 위한 Scanner 변수 선언 및 생성, 할당
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 팩토리얼 실행
        long result = f(N);
        // 결과 출력
        System.out.print(result);
    }

    public static long f(int n) {
        // 1보다 작거나 같을 경우에 1을 리턴하고 종료
        // 1과 같을 경우에만 리턴하면 N이 0일때를 판단할 수 없음
        if (n <= 1)
            return 1;
        // n이 1보다 큰 경우 재귀
        else
            return n * f(n - 1);
    }
}
