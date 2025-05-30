import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();              
        int[] arr = new int[N+1];             
        int[] dp = new int[N+1];              

        for (int i = 1; i <=N; i++) {
            arr[i] = sc.nextInt();            
            dp[i] = arr[i];                 
        }

        int maxSum = arr[1];

        for (int i = 2; i <=N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {         
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);  
        }

        System.out.println(maxSum);
    }
}
