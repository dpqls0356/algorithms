
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 입력 : N = 뽑을 수 있는 자연수의 범위 , M = 수열의 길이
 * 
 * 포인트 - 수열 [ 숫자가 중복되면 안되고 순서가 중요하다 ]
 */
public class BJ_15649 {
    static int N;
    static int M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        re(cnt);
        System.out.println(sb.toString());
    }

    public static void re(int cnt) {
        if (cnt == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (!visited[i - 1]) {
                    arr[cnt] = i;// 0->1 1->2 ...
                    visited[i - 1] = true;
                    re(cnt + 1);
                    visited[i - 1] = false;
                }
            }
        }

    }
}
