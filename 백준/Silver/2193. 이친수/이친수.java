import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1 || N == 2){
            System.out.print(1);
            System.exit(0);
        }
        if(N == 3){
            System.out.print(2);
            System.exit(0);
        }
        else if( N == 4){
            System.out.print(3);
            System.exit(0);            
        }
        
        long[] arr = new long[N+1];
        arr[3] = 2;
        arr[4] = 3;
        
        for(int i=5;i<=N;i++){
            arr[i] = arr[i-2]+arr[i-1];
        }
        
        System.out.print(arr[N]);
    }
}
