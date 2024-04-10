import java.util.Scanner;

/**
 * 문제번호 : BJ2839
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 풀이시간 : 11시 ~ 11시 9분
 * 성능
 * 메모리 : 17732 KB , 시간: 204 ms , 코드길이: 538 B
 * 
 * 문제접근
 * 5kg봉지가 가질 수 있는 최대 개수 ~ 0개 일때 각 케이스의 3kg봉지의 수를 더해서 그 합의 최소 찾기
 * 어차피 N이 5000이 최대라 1000번만 반복하면 되기때문에 시간 복잡도면에선 문제 없음
 * 
 */

public class BJ_2839 {
    public static void main(String[] args) {
        // 설탕 무게 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 최소 봉지 수를 담을 변수 선언
        int min = Integer.MAX_VALUE;
        // 5kg 봉지의 최대 개수부터 0개까지 돌면서 필요한 3kg봉지와의 합을 구하고 최소 비교하기
        for (int i = N / 5; i >= 0; i--) {
            // 5kg봉지와 3kg봉지에 모든 설탕을 담을 수 있는 경우에만 최소 비교
            if ((N - i * 5) % 3 == 0) {
                if (min > i + (N - i * 5) / 3)
                    min = i + (N - i * 5) / 3;
            }
        }
        // 한 번도 최소 값이 변한 적이 없는 경우 - 3kg과 5kg봉지를 이용해 모든 설탕을 담을 수 없는 경우
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
