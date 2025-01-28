import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] arr = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<i+1;j++){
                if(j==0||j==i){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
            }
        }
        
        System.out.print(arr[n][k]);
            
    }
}
