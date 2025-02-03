import java.util.*;
import java.io.*;

public class Main {
    
    private static long MOD =  1_000_000_007;
    private static long[][] basicArr = {{1,1},{1,0}};
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

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
        
        long[][] smallArr = cal(arr,exponent/2);
        
        long[][] resultArr = multiply(smallArr,smallArr);

        if(exponent%2!=0){
            resultArr = multiply(resultArr,basicArr);
        }         
        
        return resultArr;
    }
    
    public static long[][] multiply(long[][] arr1, long[][] arr2){
        
        long[][] resultArr = new long[2][2];
        
        for(int i=0;i<2;i++){
            for(int k=0;k<2;k++){
                for(int j=0;j<2;j++){
                    resultArr[i][k] = (resultArr[i][k]+(arr1[i][j]*arr2[j][k])%MOD)%MOD;
                }
            }
        }
        
        return resultArr;
        
    }
}
