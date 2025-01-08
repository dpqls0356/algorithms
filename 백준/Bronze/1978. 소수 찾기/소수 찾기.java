import java.util.*;
import java.io.*;

public class Main {
    private static int cnt = 0;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i=0;i<N;i++){
            int num =  sc.nextInt();
            findPrimeNumber(num);
        }
        System.out.print(cnt);
    }
    public static void findPrimeNumber(int num){
        if(num == 1)return;
        for(int i = 2;i<num;i++){
            if(num%i==0)return;
        }
        cnt++;
    }
}
