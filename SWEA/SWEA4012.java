import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제번호 : SWEA4012
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 풀이 시간 : 1사건 16분
 * 문제 분석 , 아이디어 구상 16분 + 코딩 33분 => 코딩 중간에 문제 이해를 잘 못했다는 걸 알게됨[ 재료가 무조건 2개가 아니라
 * N/2개 이니 하나의 요리마다 재료를 담을 배열이 필요했다. ]
 * 22분 => 재구성했지만 시간초과 ( 답은 전부 제대로 나왔다 )
 * 15분 => 시간 줄일 수 있게 코드 변경 통과 ~~
 * 성능
 * 메모리 : 22,992 KB , 시간: 158 ms , 코드길이: 2,802 B
 * 
 * 문제접근
 * 조합문제 : 구성이 달라야한다. 123과 321은 동일한 것으로 취급
 * 
 * 손으로 직접 재료를 나눠봤더니 음식A의 구성만 구하면 B는 자동으로 구해지는 상황
 * 
 * 작은 테케를 가지고 모든 경우의 수를 직접 구해봤는데
 * 음식A의 첫번째 재료를 1번재료로 고정하고 뒤에 두 개의 재료만 구하면 되었다.
 * 3번 재료는 2번 재료보다 항상 크다.
 * 
 * 
 */
public class SWEA4012 {
    public static int N; // 음식의 수
    public static int synergy[][]; // 시너지 값
    public static int minSub; // 최소의 맛 차이
    public static int A[]; // 음식A의 재료 번호
    public static int B[]; // 음식B의 재료 번호
    public static boolean visited[]; // 방문배열

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 테케 입력 받기
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            // 배열의 크기 입력받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            // 입력 받은 배열의 크기로 배열들 초기화
            synergy = new int[N][N];
            visited = new boolean[N];
            // 각 음식에 들어갈 재료의 수는 절반이기때문에 N/2
            A = new int[N / 2];
            B = new int[N / 2];
            // 시너지 값 입력 받기
            for (int k = 0; k < N; k++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            // System.out.println("--------------------------");
            // 가장 작은 맛 차이 찾기
            minSub = Integer.MAX_VALUE;
            // A의 1번 재료는 항상 인덱스 0으로 고정
            A[0] = 0;
            visited[0] = true;
            // cnt=1인 이유 : 이미 1번 재료는 골랐으니까
            // before를 넘겨주는 이유 : 이전 인덱스보다 큰 인덱스가 들어가야하기때문에
            find(1, 0);
            sb.append("#" + (i + 1) + " " + minSub + "\n");
        }
        System.out.println(sb.toString());
    }

    // 숫자 고르기
    public static void find(int cnt, int before) {
        // 음식 A의 재료를 다 고른 경우
        if (cnt == N / 2) {
            // 음식 B의 재료 고르기 [ 남은 재료 넣기 ]
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    B[--cnt] = i;
                    if (cnt == 0)
                        break;
                }
            }
            int sumB = 0;
            int sumA = 0;
            // 최솟값 찾기
            for (int i = 0; i < N / 2; i++) {
                for (int k = 0; k < N / 2; k++) {
                    if (i != k) {
                        // System.out.println(A[i] + " " + A[k] + " " + B[i] + " " + B[k]);
                        // System.out.println();
                        // 각 음식의 시너지 값 더하기
                        sumA += synergy[A[i]][A[k]];
                        sumB += synergy[B[i]][B[k]];
                    }
                }
            }
            // 최소 맛 차이가 연산 결과보다 크면 값 변경
            if (minSub > Math.abs(sumA - sumB))
                minSub = Math.abs(sumA - sumB);
        } else {
            // 음식A의 재료 고르기 ! 재귀 사용해서 모든 경우의 수를 따진다.
            // 단 N번째의 재료는 N-1번째 재료의 인덱스보다 큰 값을 가져야한다.
            for (int i = before + 1; i < N; i++) {
                if (!visited[i]) {
                    A[cnt] = i;
                    visited[i] = true;
                    find(cnt + 1, i);
                    visited[i] = false;
                }
            }
        }
    }
}

// 아오 재료가 무조건 2개로 생각해서 풀어버린 코드 ...
/*
 * public static void find() {
 * for(int i = 1;i<N;i++)
 * {
 * visited[i] = true;
 * A2 = i;
 * for (int k = 1; k < N; k++) {
 * if (!visited[k]) {
 * B1 = k;
 * visited[k] = true;
 * for (int j = 1; j < N; j++) {
 * if (!visited[j]) {
 * B2 = j;
 * // 맛 차이 값 구하기
 * int sum = Math
 * .abs((synergy[A1][A2] + synergy[A2][A1]) - (synergy[B1][B2] +
 * synergy[B2][B1]));
 * // System.out.println(A1 + " " + A2 + " " + B1 + " " + B2 + " " + sum);
 * // System.out.println(synergy[A1][A2] + " " + synergy[A2][A1] + " " +
 * // synergy[B1][B2] + " "
 * // + synergy[B2][B1] + " " + sum);
 * // System.out.println();
 * if (minSub > sum)
 * minSub = sum;
 * }
 * }
 * visited[k] = false;
 * }
 * }
 * visited[i] = false;
 * }
 * }
 */