
import java.util.Scanner;

public class BJ_2563 {
    /**
     * 
     * 작성자 : 이예빈
     * 문제 : BJ2563
     * 결과 : 맞았습니다!!
     * 성능 요약 : 메모리: 17844 KB, 시간: 216 ms, 코드길이 : 1244 b
     * 
     */
    public static void main(String args[]) {

        // 입력을 받기위한 변수 선언 및 생성, 할당
        Scanner sc = new Scanner(System.in);
        // 100X100짜리 배열
        int arr[][] = new int[100][100];
        // 입력받는 횟수 받기
        int T = sc.nextInt();
        // T만큼 반복문 돌리며
        for (int i = 0; i < T; i++) {
            // x축 시작값과 y축 시작값 받기
            int X = sc.nextInt();
            int Y = sc.nextInt();
            // x에서부터 x+10전까지 돌기
            for (int k = X; k < X + 10; k++) {
                // y에서부터 y+10전까지 돌기
                for (int j = Y; j < Y + 10; j++) {
                    // 각각 값이 범위내에 있을 경우 1로 변경하기
                    if (k <= 100 && j <= 100)
                        arr[k][j] = 1;
                }
            }
        }
        // 1로 변한 곳의 갯수 구하기
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int k = 0; k < 100; k++) {
                if (arr[i][k] == 1)
                    count++;
            }
        }
        System.out.println(count);
    }

}
