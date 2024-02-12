import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제번호 : SWEA1228
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 성능
 * 메모리 : 18,624 KB , 시간: 114 ms , 코드길이: 1815 B
 * 
 * 문제접근
 * 데이터들이 순서 있게 들어가있다 -> 배열을 사용해야겠다고 판단
 * 그러나 특정 위치에 데이터를 삽입해야하기때문에 배열보단 LinkedList가 더 알맞을 것이라 판단
 * 
 */
public class SWEA1228 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스만큼 반복문 돌리기
        for (int i = 0; i < 10; i++) {
            // 암호문 길이 입력받기
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            // 데이터를 담을 LinkedList 변수 선언과 생성, 할당
            LinkedList<Integer> list = new LinkedList<>();
            // 원본 암호문 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            // 명령어 개수 입력받기
            st = new StringTokenizer(br.readLine());
            int calcnt = Integer.parseInt(st.nextToken());
            // 실행해야하는 명령어들 한 줄로 받기
            String cals = br.readLine();
            // I를 기준으로 문자열 분리 - calArr 한 공간엔 하나의 명령문만 존재.
            String calArr[] = cals.split("I");
            for (int k = 1; k < calcnt + 1; k++) {
                // 1부터 시작하는 이유 0에 공백 문자열이기때문
                // 한 줄의 명령어들 공백을 기준으로 분리
                String arr[] = calArr[k].split(" ");
                // 3번 인덱스부터 추가해야하는 암호값들이 들어있어 index를 3으로 하고
                int index = 3;
                // 추가해야하는 위치부터 추가해야하는 개수만큼 반복문을 돌며 데이터 삽입
                for (int j = Integer.parseInt(arr[1]); j < Integer.parseInt(arr[1]) +
                        Integer.parseInt(arr[2]); j++) {
                    list.add(j, Integer.parseInt(arr[index]));
                    // 인덱스 + 1 = 다음 암호문 숫자를 받아오기 위함
                    index++;
                }
            }
            sb.append("#" + (i + 1) + " ");
            for (int k = 0; k < 10; k++) {
                sb.append(list.get(k) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
