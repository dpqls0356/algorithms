
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : 15649
 * 작성자 : 이예빈
 * 문제 풀이 시간 : 1시 25분 ~ 2시 32분 / 1시간 7분 ㄷㄷ
 * 결과 : 맞았습니다!!
 * 메모리 : 86048kb
 * 시간 : 2240ms
 * 코드길이 : 963B
 * 풀이과정
 * N과 M을 받기
 * N만큼 main에서 돌리기 = 길이가 1인 경우를 고려
 * String str에 출력할 숫자들을 담음 / str의 길이는 순열의 길이 판단에 사용
 * 재귀 함수에 들어간 경우
 * 1. str의 길이가 M보다 작은 경우
 * 다음 순서에 올 숫자 찾기 contains사용
 * 1~N을 돌며 가능한 숫자 찾기
 * 불가능할 경우 continue
 * 가능한 경우 붙이고 재귀돌리기 => 중요한 것 : 재귀 돌리고 문자열 길이 1만큼 줄이기
 * 2. str의 길이가 M보다 큰 경우
 * 출력
 */

public class BJ15649 {

    public static void recursive(int N, int M, String str) {
        // str의 길이가 M보다 작은 경우
        if (str.length() < M) {
            // 다음에 올 숫자 탐색
            for (int i = 1; i < N + 1; i++) {
                // 이미 사용된 숫자면 continue;
                if (str.contains(Integer.toString(i)))
                    continue;
                else {
                    // 사용한 적 없는 숫자일 경우 str에 붙이고 다음 숫자를 찾기 위해 자기자신 호출
                    recursive(N, M, str += (Integer.toString(i)));
                    // 위에 코드이 돌아가면 문자열의 길이가 1 늘어나기에 줄여주기
                    str = str.substring(0, str.length() - 1);
                }
            }
        }
        // 기저조건 : str의 길이가 M보다 크거나 같은 경우
        if (str.length() >= M) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) throws IOException {
        // 입력을 받기위한 버퍼더리더 변수 선언 및 생성과 할당
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받은 데이터에서 공백 단위로 분리하여 할당
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 사용할 수 있는 숫자의 범위
        int N = Integer.parseInt(st.nextToken());
        // M 만들 수 있는 순열의 길이
        int M = Integer.parseInt(st.nextToken());
        // 1~N까지 반복을 돌며 찾기
        for (int i = 1; i < N + 1; i++) {
            recursive(N, M, Integer.toString(i));

        }

    }
}
