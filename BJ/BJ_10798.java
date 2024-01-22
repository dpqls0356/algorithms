package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10798 {

    /**
     * BJ_10798
     * 작성자 : 이예빈
     * 제출: 24.01.20
     * 결과 : 맞았습니다!!
     * 성능요약 : 메모리 : 14212kb , 시간 : 120ms , 길이 :733 b
     * 접근법
     * > String으로받고 char배열로 만들기
     * > 가장 긴 단어의 길이를 변수에 담아두고 그 변수의 값만큼 반복문 돌리기
     * > 세로로 탐색 시 해당 행의 글자열의 길이보다 i값이 작으면 append하기
     *
     */
    public static void main(String[] args) throws IOException {

        // 출력을 위한 StringBuilder 변수 선언 및 생성, 할당
        StringBuilder sb = new StringBuilder();
        // 입력을 위한 BufferedReader,StringTokenizer 변수 선언 및 생성, 할당
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 5행으로 이루어진 다차원 배열 선언 및 생성 ,할당
        char arr[][] = new char[5][];
        // 길이가 가장 긴 단어를 담을 변수 선언
        int length = Integer.MIN_VALUE;
        // 5번 반복하며 데이터 받기
        for (int i = 0; i < 5; i++) {
            // 문자열로 받아
            st = new StringTokenizer(br.readLine());
            // 문자 배열로 변경
            arr[i] = st.nextToken().toCharArray();
            // 가장 길이가 긴 단어의 길이 구하기
            if (length < arr[i].length) {
                length = arr[i].length;
            }
        }
        // 세로로 탐색 시 해당 행의 글자열의 길이보다 i값이 작으면 append하기
        // 가장 긴 단어까지는 반복문이 실행되어야하기때문에 i<length로 설정
        for (int i = 0; i < length; i++) {
            // 단어가 5개라서 5번 돌기
            for (int k = 0; k < 5; k++) {
                // 해당 열의 단어의 길이가 i보다 긴 경우에만 출력
                // 짧을경우엔 출력 x
                if (arr[k].length > i) {
                    sb.append(arr[k][i]);
                }
            }
        }
        System.out.print(sb);
    }

}
