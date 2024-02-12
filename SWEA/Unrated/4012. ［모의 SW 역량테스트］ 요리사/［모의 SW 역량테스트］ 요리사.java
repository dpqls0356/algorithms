import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14분
public class Solution {
    public static int N;
    public static int synergy[][];
    public static int minSub;
    public static int A[];
    public static int B[];
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            // 배열의 크기 입력받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            synergy = new int[N][N];
            visited = new boolean[N];
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
            A[0] = 0;
            visited[0] = true;
            find(1, 0);
            sb.append("#" + (i + 1) + " " + minSub + "\n");
        }
        System.out.println(sb.toString());
    }

    // 숫자 고르기
    public static void find(int cnt, int before) {
        if (cnt == N / 2) {
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
                        sumA += synergy[A[i]][A[k]];
                        sumB += synergy[B[i]][B[k]];
                    }
                }
            }
            if (minSub > Math.abs(sumA - sumB))
                minSub = Math.abs(sumA - sumB);
        } else {
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
