import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T>0){
            int n = sc.nextInt();
            long[] arr = new long[n+1];
            
            if(n<=3){
                sb.append(1+"\n");
                T--;
               continue;
            }
            
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            
            for(int i = 4;i<=n;i++){
                arr[i] = arr[i-2] + arr[i-3];
            }
            
            sb.append(arr[n]+"\n");
            T--;
        }
        
        System.out.print(sb.toString());
    }
}
