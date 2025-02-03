import java.util.*;
import java.io.*;

public class Main {
    
    private static long MOD =  1_000_000_007;
    private static long[][] basicArr = {{1,1},{1,0}};
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        // long N = sc.nextLong()%MOD; 피보 4인가 5에선 주기가 있었기에 %MOD를 했지만 지금은 하면 안됨
        long N = sc.nextLong();
        
        if(N==0||N==1){
            System.out.print(N);
            System.exit(0);
        }
        
        long[][] resultArr = cal(basicArr,N-1);
        
        System.out.print(resultArr[0][0]);    
            
    }
    
    public static long[][] cal(long[][] arr,long exponent){
        
        if(exponent==0){ 
            return new long[][]{{1,0},{0,1}};
        }
        if(exponent==1){
            return basicArr;
        }
        
        long[][] resultArr = new long[2][2];
        
        long[][] smallArr = cal(arr,exponent/2);
        
        //행렬곱하기 단 계산마다 %mod
        for(int i=0;i<2;i++){
            for(int k=0;k<2;k++){
                for(int j=0;j<2;j++){
                    resultArr[i][k] = (resultArr[i][k]+(smallArr[i][j]*smallArr[j][k])%MOD)%MOD;
                }
            }
        }
        
        //홀수면 한번 더 곱해야함
        // if(exponent%2!=0){
            // for(int i=0;i<2;i++){
                // for(int k=0;k<2;k++){
                    // for(int j=0;j<2;j++){
                        // resultArr[i][k] = (resultArr[i][k]+(basicArr[i][j]*smallArr[j][k])%MOD)%MOD;
                    // }
                // }
            // }
        // }
        if(exponent%2!=0){
            long[][] temp = new long[2][2];  // 임시 배열 사용
            for(int i=0;i<2;i++){
                for(int k=0;k<2;k++){
                    for(int j=0;j<2;j++){
                        temp[i][k] = (temp[i][k]+(arr[i][j]*resultArr[j][k])%MOD)%MOD;
                    }
                }
            }
            return temp;  // 임시 배열 반환
        }         
        
        return resultArr;
    }
}
