import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long[] arr = new long[2];
        
        arr[0] = 0;
        arr[1] = 1;
        
        if(n == 0||n==1){
            System.out.print(n);
            System.exit(0);
        }
        for(int i=2;i<=n;i++){
            long temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp+arr[0];
        }
        System.out.print(arr[1]);
    }
}

