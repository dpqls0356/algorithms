import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String args[]) throws IOException {
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
                    // System.out.print(arr[i][k]+" ");
                }
                // System.out.println();
            }
            int maxSum = Integer.MIN_VALUE;
            // //x축 이동
            // for(int i=1;i<=N-M+1;i++) {
            // //y축 이동
            // for(int k=1;k<=N-M+1;k++) {
            // int sum=0;
            // //y축 중 범위 내의 누적합 구하기
            // for(int p = k;p<M+k;p++) {
            //// sum+=(arr[p][i+M-1]-arr[p][i-1]);
            // sum+=arr[][]-arr[][]
            // }
            // if(maxSum<sum)maxSum = sum;
            // }
            // }
            // //x축 이동
            // for(int i=1;i<=N-M+1;i++) {
            // //y축 이동
            // for(int k=1;k<=N-M+1;k++) {
            // int sum=0;
            // //여기 조건만 바꾸면 된다.
            // for(int p = k;p<k+M;p++) {
            // System.out.println((i)+" "+(k+M-1)+" "+(i)+" "+(k-1));
            //
            // }
            // if(sum>maxSum) {
            // maxSum = sum;
            // }
            // }
            // System.out.println();
            // }

            for (int i = 1; i <= N - M + 1; i++) {
                for (int k = 1; k <= N - M + 1; k++) {
                    int sum = 0;
                    for (int p = 0; p <= M - 1; p++) {
                        // System.out.println((i+p)+" "+(k+M-1)+" "+(i+p)+" "+(k-1));
                        sum += (arr[i + p][k + M - 1] - arr[i + p][k - 1]);
                    }
                    if (maxSum < sum)
                        maxSum = sum;
                }
                // System.out.println();
            }

            sb.append("#" + j + " " + maxSum + "\n");
        }
        System.out.println(sb.toString());
    }
}
