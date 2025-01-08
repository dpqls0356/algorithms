import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        
        Scanner  sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        boolean[] isPrime = new boolean[M+1];
        
        for(int i = 2;i<=M;i++){
            isPrime[i] = true;
        }
        
        for(int i=2;i<=M;i++){
            int k = 2;
            if(isPrime[i]){
                while(i*k<=M){
                    isPrime[i*k] = false;
                    k++;
                }                   
            }
        }
        
        for(int i=N;i<=M;i++){
            if(isPrime[i])sb.append(i+"\n");
        }
        
        System.out.print(sb.toString());
    
    }
    

    
}
