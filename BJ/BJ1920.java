
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class BJ1920 {
    // 데이터 = 100000 -> n^2은 사용불가 (1, logN , n, NlogN, N^2)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int num[] = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int findNum = num[i];
            // 인덱스값
            int start = 0;
            int end = N - 1;
            boolean check = false;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (A[mid] == findNum) {
                    check = true;
                    break;
                } else if (A[mid] < findNum) {
                    start = mid + 1;
                } else if (A[mid] > findNum) {
                    end = mid - 1;
                }
            }
            if (check) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        // 틀렸던 이유 : end값을 잘못 설정함 -> 그냥 인덱스에 맞추면 되는거였다...
        // 두번째 문제 : 시간초과 이유는 ? 모름..
        // for (int i = 0; i < M; i++) {
        // int findNum = num[i];
        // int start = 0;
        // int end = N - 1;
        // int len = N;
        // while (true) {
        // if (A[len / 2 + start] == findNum) {
        // System.out.println(1);
        // break;
        // } else if (len == 2) {
        // if (A[start] == findNum || A[end] == findNum) {
        // System.out.println(1);
        // break;
        // } else {
        // System.out.println(0);
        // break;
        // }
        // } else if (len == 1 || len == 0) {
        // if (A[start] == findNum) {
        // System.out.println(1);
        // break;
        // } else {
        // System.out.println(0);
        // break;
        // }
        // } else if (A[len / 2] + start < findNum) {
        // start = len / 2 + 1;
        // } else if (A[len / 2] + start > findNum) {
        // end = len / 2 - 1;
        // }
        // len = end - start + 1;
        // }
        // }
    }
}
