import java.util.*;
import java.io.*;

public class Main {
    
    private static ArrayList<Integer> top = new ArrayList<>();
    private static ArrayList<Integer> bottom = new ArrayList<>();
    private static boolean[] isPrime;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        long result = cal(A,B,C);
        System.out.print(result);
    }
    
    public static long cal(int base,int exponent,int mod){
        if(exponent == 0)return 1;
        
        long num = cal(base,exponent/2,mod);
        
        long result = (num*num)%mod;
        
        if(exponent%2!=0){
            result = (result*base)%mod;
        }
        return result;
    }
    
}
