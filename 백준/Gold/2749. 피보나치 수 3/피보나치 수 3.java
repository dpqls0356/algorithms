import java.util.*;
import java.io.*;

/*
    주기p = ? 15*10^5
    나누는 수 m = 1,000,000 m=10^k이면 주기는 15*10^(k-1) 
*/
public class Main {
    private static long MOD = 1000000;
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        long n  = sc.nextLong();
        int p = (int)(15*Math.pow(10,5));
        
        long[] fibo = new long[p];
        fibo[0] = 0;
        fibo[1] = 1;
        
        for (int i=2; i<p; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] %= MOD;
        }
        
        System.out.print(fibo[(int)(n%p)]);
            
        
    }
}
