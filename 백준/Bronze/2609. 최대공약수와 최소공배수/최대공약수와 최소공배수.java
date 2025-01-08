import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int greatestCommonDivisor = findCommondivisor(A,B);
        int greatestCommonMultiple =  findCommonMultiple(A,B);
        
        System.out.print(greatestCommonDivisor+"\n"+greatestCommonMultiple);
    }
    public static int findCommondivisor(int A,int B){
        int result = 1;
        int N = A<B?A:B;
        for(int i=1;i<=N;i++){
            if(A%i==0&&B%i==0)result = i;
        }
        return result;
        
    }
    public static int findCommonMultiple(int A,int B){
        int i = 1;
        int k = 1;
        int small = A<B?A:B;
        int big = A<B?B:A;
        while(true){
            if(small*i==big*k)break;
            else{
                i++;
                if(small*i>big*k)k++;
            }
        }
        return small*i;
    }
}
