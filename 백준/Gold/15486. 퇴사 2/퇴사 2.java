import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n+1];
        int[] c = new int[n+1];
        int[] dp = new int[n+1];
        
        for(int i=1;i<=n;i++){
            t[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        
        for(int i=1;i<=n;i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            int dest = i+t[i]-1;
            if(dest<=n){
                dp[dest] = Math.max(c[i]+dp[i-1],dp[dest]);
            }
        }
        
        int max = dp[0];
        for(int i = 1;i<=n;i++){
            if(dp[i]>max)max=dp[i];
        }
        System.out.print(max);
    }
}
