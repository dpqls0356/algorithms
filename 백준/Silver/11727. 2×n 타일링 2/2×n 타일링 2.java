import java.util.*;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.print(1);
            return;
        }
        else if(n == 2){
            System.out.print(3);
            return;
        }
        else{
            int[] arr = new int[n+1];
            arr[1] = 1;
            arr[2] = 3;
            for(int i=3;i<=n;i++){
                arr[i] = (arr[i-2]*2+arr[i-1])%10_007;
            }
            System.out.print(arr[n]);
        }
    }
}
