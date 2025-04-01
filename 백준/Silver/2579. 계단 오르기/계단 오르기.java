import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] score = new int[n+1];
        
        for(int i=1;i<=n;i++){
            score[i] = sc.nextInt();
        }
        
        int[][][] dp = new int[n+1][2][3]; // 계단번호, 밟음 여부, 현재 위치를 포함해 밟은 계단
        
        dp[1][1][1] = score[1];
        
        for(int i=2;i<=n;i++){
            dp[i][1][1] = dp[i-1][0][0] + score[i];
            dp[i][1][2] = dp[i-1][1][1] + score[i];
            dp[i][0][0] = dp[i-1][1][1] > dp[i-1][1][2]? dp[i-1][1][1]: dp[i-1][1][2];
        }
        System.out.println(dp[n][1][1] > dp[n][1][2] ? dp[n][1][1] : dp[n][1][2]);
        
    }
}
