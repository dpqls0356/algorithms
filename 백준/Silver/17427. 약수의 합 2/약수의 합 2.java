import java.util.*;
import java.io.*;

public class Main {
    
    private static int N;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        
        //f(a) = a의 약수의 합
        //g(x) = x보다 작거나 같은 모든 자연수 y의 f(y)를 전부 더한 값 , 결국 x보다 작거나 같은 수의 약수의 합의 합
        
        long sum = cal();
        
        System.out.print(sum);
        
    }
    public static long cal(){
        long[] divisorSum = new long[N+1];
        
        // 1부터 N까지 모든 약수 계산
        for(int i = 1; i <= N; i++) {
            // i의 배수에 i를 더함
            for(int j = i; j <= N; j += i) {
                divisorSum[j] += i;
            }
        }
        
        // 모든 약수의 합 계산
        long total = 0;
        for(int i = 1; i <= N; i++) {
            total += divisorSum[i];
        }
        
        return total;
     } 
}
