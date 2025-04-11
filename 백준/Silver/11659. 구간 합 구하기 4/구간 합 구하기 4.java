import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int arr[] = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        
        for(int k=1;k<=n;k++){
            int num = Integer.parseInt(st.nextToken());
                arr[k] = num +arr[k-1];
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append((arr[b]-arr[a-1])+"\n");
        }
        
        System.out.print(sb.toString());
    }
}
        // for(int k=1;k<=n;k++){
            // for(int i=1;i<=n;i++){
              // System.out.print(arr[k][i]+" ");
            // }
            // System.out.println();
        // }