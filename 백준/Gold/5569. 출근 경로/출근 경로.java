import java.util.*;

public class Main {
    static int mod = 100000;
    static int w, h;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        int[][][][] dp = new int[w + 1][h + 1][2][2];
        
        for(int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        } 
        for(int i = 1; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }
 
        for(int i = 2; i <= w; i++) {
            for(int j = 2; j <= h; j++) {
                dp[i][j][1][0] = (dp[i][j - 1][1][1] + dp[i][j - 1][1][0]) % mod;
                dp[i][j][1][1] = dp[i][j - 1][0][0] % mod;
                dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % mod;
                dp[i][j][0][1] = dp[i - 1][j][1][0];
            }
        }
        int result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % mod; 
        System.out.println(result);
    }
}
