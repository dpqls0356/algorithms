import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
                
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = arr[1];
        dp[1] = arr[1];
        
        for(int i=2;i<=n;i++){
            // 연속적으로 더해갈때 + + / + - 
            // 단 더하는 값이 양수이거나 / 음수더라도 현재까지 더해온 값보다 작을 경우에만
            if(dp[i-1]>=0&&(arr[i]>=0||(arr[i]<0&&Math.abs(arr[i])<dp[i-1]))){
                dp[i] = dp[i-1]+arr[i];
                if(dp[i]>max) max = dp[i];
            }
            else{
                dp[i] = arr[i];
                if(dp[i]>max) max = dp[i];
            }
        }
        System.out.print(max);
    }
}
