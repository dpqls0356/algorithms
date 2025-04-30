import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n+1];
        int[] cost = new int[n+1];
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            time[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }
        
        int memo = 0;
        
	     for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int dest = i + time[i] - 1;
            if (dest <= n) {
                dp[dest] = Math.max(dp[dest], dp[i - 1] + cost[i]);
            }
        }
        
        int max = dp[0];
        for(int i=1;i<=n;i++){
            if(dp[i]>max) max = dp[i];
        }
        
        System.out.print(max);
        
        sc.close();
    }
}
