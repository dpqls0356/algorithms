import java.util.*;

public class Main {
    
    private static int MOD =  1_000_000_000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10]; // 1~n = 길이 , 0~9 = 끝자리수
        
        //자리수가 1일때는 가질 수 있는 경우의 수는 전부 1 , 단 0은  0임... 
        for(int i=1;i<10;i++){
            dp[1][i] = 1;
        }
        
        for(int i=2;i<=n;i++){
            for(int k=0;k<10;k++){
                if(k>0){
                    dp[i][k] += dp[i-1][k-1];
                }
                if(k<9){
                    dp[i][k] +=dp[i-1][k+1];
                }
                dp[i][k]%=MOD;
            }
        }
        
        int result = 0;
        for(int i=0;i<10;i++){
           result = (result+dp[n][i])%MOD;
        }
        
        System.out.print(result);
    }
}
