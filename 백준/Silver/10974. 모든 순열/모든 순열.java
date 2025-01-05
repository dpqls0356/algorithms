import java.util.*;
import java.io.*;

public class Main {
    
    private static int n;
    private static boolean[] visited;
    private static int[] arr;
    private static StringBuilder sb= new StringBuilder();
    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        visited = new boolean[n+1];
        recrusive(0);
        
        System.out.println(sb.toString());
        
    }
    
    public static void recrusive(int depth){
        if(depth==n){
            StringBuilder permutation = new StringBuilder();
            for(int i=1;i<=n;i++){
                permutation.append(arr[i]+" ");
            }
            permutation.append("\n");
            sb.append(permutation.toString());
        }
        else{
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    arr[depth+1] = i ;
                    visited[i] =true;
                    recrusive(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
