import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int j = 1; j < T + 1; j++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr[][] = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k < N + 1; k++) {
                    arr[i][k] = arr[i][k - 1] + Integer.parseInt(st.nextToken());
                }
            }
            int maxSum = Integer.MIN_VALUE;
            for (int i = 1; i < N + 1 - M; i++) {
                int sum = 0;
                for (int k = 1; k < N + 1 - M; k++) {
                    sum += (arr[i][M + k - 1] - arr[i][k]);
                }
                System.out.println(sum);
                if (sum > maxSum)
                    maxSum = sum;
            }
            sb.append("#" + j + " " + maxSum);
        }
        System.out.println(sb.toString());
    }
}
