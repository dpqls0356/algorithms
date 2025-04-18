import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=1;k<=i;k++){
                arr[i][k] = Long.parseLong(st.nextToken());
            }
        }
        for(int i=n-1;i>=1;i--){
            for(int k = 1; k<=i;k++){
                arr[i][k] += Math.max(arr[i+1][k],arr[i+1][k+1]);
            }
        }
        System.out.print(arr[1][1]);
    }
}
