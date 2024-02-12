package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17406 {
    /**
     * 정말 .. 배열 돌릴떄마다 인덱스 범위 지정하느라 내가 돌 것만 같다.............
     * 그래도 ............ 골드4 문제 스스로 풀어서 뿌듯해요 .............
     * 문제 : BJ17406
     * 작성자 : 이예빈
     * 문제 풀이 시간:3시간?
     * .......... 문제 분석하고 로직 간단하게 짜는데 40분 .... 구현하는데 2시간.....
     * 아오 분석을 30분 더해서라도 인덱스 범위 정하는걸 다 구해놨으면 구현하는데 이렇게 오래 걸리지않았을텐데
     * 결과 : 맞았습니다.
     * 메모리 : 95172kb
     * 시간 : 428ms
     * 코드 길이 : 5033b
     * 
     */
    // 가장 작은 배열의 값을 담을 변수 선언
    public static int minSum = Integer.MAX_VALUE;
    // 배열의 크기 N x M
    public static int N;
    public static int M;
    // 연산횟수
    public static int R;
    // 현재 진행한 연산의 횟수
    public static int cnt;
    // 실행했던 연산인지 체크하기 위한 방문배열
    public static boolean visited[];
    // 연산을 담을 배열
    public static int calArr[][];

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열의 크기와 연산 횟수 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력
        int arr[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 입력
        calArr = new int[R][3];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            calArr[i][0] = Integer.parseInt(st.nextToken());
            calArr[i][1] = Integer.parseInt(st.nextToken());
            calArr[i][2] = Integer.parseInt(st.nextToken());
        }
        // 방문 배열의 크기 설정
        visited = new boolean[R];
        // 가장 작은 배열의 값 찾는 함수 호출
        find(0, arr);
        // System.out.println("Array :" + minSum);
        // 결과 출력
        System.out.println(minSum);
    }

    // 연산횟수와 돌릴 배열을 매개변수로 받는다.
    public static void find(int cnt, int arr[][]) {
        // 연산 전 배열 복사
        int beforeArr[][] = new int[N][M];
        for (int i = 0; i < arr.length; i++) {
            beforeArr[i] = arr[i].clone();
        }
        // 현재의 연산 횟수가 입력한 연산 횟수와 일치할 경우 배열의 값 계산 후 최소비교
        if (cnt == R) {
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += arr[i][k];
                    // System.out.print(arr[i][k] + " ");
                }
                if (sum < minSum)
                    minSum = sum;
                // System.out.println();
            }
            // System.out.println("------------------");

        } else {
            // 모든 경우의 수를 돌리는데 이미 방문(연산)한 곳이면 연산 안하도록 함
            for (int i = 0; i < R; i++) {
                if (!visited[i]) {
                    // System.out.println(cnt + " " + i);
                    rotate(i, arr);
                    visited[i] = true;
                    find(cnt + 1, arr);
                    // 연산을 하고 돌아온 경우 이전 배열로 돌아가기
                    for (int k = 0; k < beforeArr.length; k++) {
                        arr[k] = beforeArr[k].clone();
                    }
                    // 방문배열 값도 변경
                    visited[i] = false;
                }
            }
            // 배열돌리고 다음케이스 불리기
        }
    }

    public static void rotate(int i, int arr[][]) {

        // 돌려야하는 배열의 왼쪽 위 좌표값과 오른쪽 아래 좌표값 구하기
        int frontx = calArr[i][0] - calArr[i][2] - 1; // 0
        int fronty = calArr[i][1] - calArr[i][2] - 1; // 1
        int backx = calArr[i][0] + calArr[i][2] - 1; // 4
        int backy = calArr[i][1] + calArr[i][2] - 1; // 5

        // 돌려야하는 공간의 길이
        int row = backy - fronty;
        int col = backx - frontx;

        // 돌려야하는 횟수 : 가로 세로 길이 중 작은 값 / 2
        for (int t = 0; t < Math.min(row, col) / 2; t++) {
            // 복사되어 사라지는 하나의 값은 tmp에 미리 저장
            int tmp = arr[frontx + t][backy - t];
            // 오른쪽 이동
            for (int k = backy - t; k > fronty + t; k--) {
                arr[t + frontx][k] = arr[t + frontx][k - 1];
            }
            // 위쪽 이동
            for (int k = frontx + t; k < backx - t; k++) {
                // System.out.println(arr[k + 1][fronty + t] + " " + arr[k][fronty + t]);
                arr[k][fronty + t] = arr[k + 1][fronty + t];
            }
            // 왼쪽 이동
            for (int k = fronty + t; k < backy - t; k++) {
                // System.out.println(arr[backx - t][k] + " " + arr[backx - t][k + 1]);
                arr[backx - t][k] = arr[backx - t][k + 1];
            }
            // 아래쪽 이동
            for (int k = backx - t; k > frontx + 1 + t; k--) {
                // System.out.println(arr[k][backy - t] + " " + arr[k - 1][backy - t]);
                arr[k][backy - t] = arr[k - 1][backy - t];
            }
            // System.out.println("-" + (frontx + t + 1) + " " + (backy - t) + " " + tmp);
            // 값이 복사되어 이동시키지 못한 부분에
            arr[frontx + t + 1][backy - t] = tmp;
        }
    }
}
// 시작 시작col
// 시작지점 : calArr[i][0]-calArr[i][2], calArr[i][1] - calArr[i][2] 에서
// 끝 끝 col
// calArr[i][0]+calArr[i][2], calArr[i][1] + calArr[i][2]
// 시작지점에서 끝부분 높이 길이 구하는 공식
// (calArr[i][0]+calArr[i][2])-(calArr[i][0]-calArr[i][2]+1)
// 시작지점에서 끝부분 가로 길이 구하는 공식 (calArr[i][1] + calArr[i][2]) - (calArr[i][1] -
// calArr[i][2])
// 돌리는 방법 오른쪽으로 밀기 위로 밀기 왼쪽으로 밀기 아래로 밀기 [ 위쪽 오른쪽 상단 값을 tmp에 담아야한다...... ]
