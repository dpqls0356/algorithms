import java.util.*;
import java.io.*;


public class Main {
    
    private static int size;
    private static ArrayList<Integer> arr = new ArrayList<>();
    private static boolean[] isPrime;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int maxNum = 0;
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int inputNum = Integer.parseInt(st.nextToken());
            
            if(inputNum == 0) break;
            
            arr.add(inputNum);
            
            if(maxNum<inputNum)maxNum =inputNum;
        }
        
        isPrime = new boolean[maxNum+1];
        
        for(int i = 2;i<=maxNum;i++){
            isPrime[i] = true;
        }
        
        for(int i= 2;i<=Math.sqrt(maxNum);i++){
            if(isPrime[i]){
                for(int k = i;k<=maxNum/i;k++){
                    isPrime[k*i] = false;
                }
            }
        }
        
        for(int i=0;i<arr.size();i++){
            findFunc(arr.get(i));
        }
        
        System.out.print(sb.toString());
        
    }
    
    private static void findFunc(int num){
        for(int i = 3;i<=num;i++){
            if(isPrime[i]&&i%2!=0){
                int otherNum = num - i;
                if(isPrime[otherNum]&&otherNum%2!=0){
                    sb.append(num+" = "+i+" + "+otherNum+"\n");
                    return;
                }
            }
        }
        sb.append("Goldbach's conjecture is wrong.\n");
    }
}
