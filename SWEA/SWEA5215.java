import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제번호 :SWEA 5215
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 풀이시간 : 34분
 * 성능
 * 메모리 : 20,380 KB , 시간: 203 ms , 코드길이: 2,085 B
 * 
 * 문제접근
 * 재료를 넣을지 넣지않을지를 선택하는 방식으로 재귀를 사용
 * 
 */
public class SWEA5215 {
    public static int foodCnt; // 재료의 개수
    public static int limitCal; // 제한된 칼로리
    public static int foods[]; // 재료의 점수를 담을 배열
    public static int cals[]; // 재료의 칼로리를 담을 배열
    public static int maxFoodTaste; // 최대 점수
    public static int sumFoodTaste; // 점수의 합
    public static int sumFoodCal; // 칼로리의 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 테케 입력 받기
        int T = (Integer.parseInt(st.nextToken()));
        // 테케만큼 반복
        for (int i = 0; i < T; i++) {
            // 재료의 개수와 제한칼로리 입력받기
            st = new StringTokenizer(br.readLine());
            foodCnt = Integer.parseInt(st.nextToken());
            limitCal = Integer.parseInt(st.nextToken());
            // 재료의 개수만큼 배열의 공간 할당
            foods = new int[foodCnt];
            cals = new int[foodCnt];
            // 각 재료의 점수와 칼로리 입력 받기
            for (int k = 0; k < foodCnt; k++) {
                st = new StringTokenizer(br.readLine());
                foods[k] = Integer.parseInt(st.nextToken());
                cals[k] = Integer.parseInt(st.nextToken());
            }
            // 점수, 칼로리, 최대 점수 값 초기화해주기
            maxFoodTaste = 0;
            sumFoodTaste = 0;
            sumFoodCal = 0;
            // 최고의 햄버거를 찾는 함수 호출
            find(0);
            // 결과 출력
            System.out.println("#" + (i + 1) + " " + maxFoodTaste);
        }

    }

    public static void find(int cnt) {
        // 재귀를 부른 횟수가 재료의 개수와 일치할 때
        if (cnt == foodCnt) {
            // 칼로리의 합이 제한 칼로리를 넘지않는 경우
            if (limitCal >= sumFoodCal) {
                // 최대 점수가 점수의 합 보다 작으면 값 변경
                if (sumFoodTaste > maxFoodTaste)
                    maxFoodTaste = sumFoodTaste;
            }
        } else {
            // 자신의 재료 포함 안하고 돌리기
            find(cnt + 1);
            // 자신의 재료 포함하고 돌리기 단, limitCal를 넘어가지않는 경우만
            if (limitCal >= sumFoodCal + cals[cnt]) {
                sumFoodCal += cals[cnt];
                sumFoodTaste += foods[cnt];
                find(cnt + 1);
                sumFoodCal -= cals[cnt];
                sumFoodTaste -= foods[cnt];
            }

        }
    }
}
