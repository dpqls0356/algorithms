import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        
        int T = Integer.parseInt(st.nextToken());
        
        int inputArr[] = new int[T];
        int big = Integer.MIN_VALUE;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            inputArr[i] = Integer.parseInt(st.nextToken());
            if(big<inputArr[i])big = inputArr[i];
        }
        
        long[] sumArr = new long[big+1];
        
        //각 숫자에 대한 f(A);
        for(int i=1;i<=big;i++){
            for(int k=i;k<=big;k+=i){
                sumArr[k]+=i;
            }
        } 
        long[] result = new long[big+1];
        result[1] = sumArr[1];
        for(int i=2;i<=big;i++){
            result[i] = result[i-1]+sumArr[i];
        }
        
        for(int i=0;i<T;i++){
            sb.append(result[inputArr[i]]+"\n");
        }
        

        
        System.out.print(sb.toString());
    }
}
