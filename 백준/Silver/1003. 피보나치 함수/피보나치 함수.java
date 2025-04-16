import java.util.*;
 
public class Main{
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
 
        int[][] arr = new int[41][2];
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[0][0] = 1;
        arr[0][1] = 0;
 
        for(int i=2;i<=40;i++){
            arr[i][0] = arr[i-1][0]+arr[i-2][0];
            arr[i][1] = arr[i-1][1]+arr[i-2][1];
        }
        int T = sc.nextInt();
 
        while(T>0){
            int N = sc.nextInt();
            sb.append(arr[N][0]+" "+arr[N][1]+"\n");
            T--;
        }
 
        System.out.print(sb.toString());
    }
}