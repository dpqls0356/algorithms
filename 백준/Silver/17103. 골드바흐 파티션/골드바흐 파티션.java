import java.util.*;
import java.io.*;

public class Main {
    
    private static boolean [] isPrime = new boolean[1000000+1];

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int i=2;i<isPrime.length;i++){
            isPrime[i] = true;
        }
        
        for(int i=2;i<Math.sqrt(isPrime.length);i++){
            if(isPrime[i]){
                int k = 2;
                while(i*k<isPrime.length){
                    isPrime[k*i] = false;
                    k++;
                }
            }
        }
        
        
        for(int i = 0 ;i< T;i++){
            int num = sc.nextInt();
            int result = find(num);
            sb.append(result+"\n");        
        }
        
        System.out.print(sb.toString());
    }
    
    public static int find(int num){
        int cnt = 0;
        HashSet<String> history = new HashSet<>();
        for(int i=2;i<num;i++){
            if(isPrime[i]&&isPrime[num-i]){
                int small = i>num-i?num-i:i;
                int big = i>num-i?i:num-i;
                if(!history.contains(small+" "+big)){
                    cnt++;
                    history.add(small+" "+big);
                }
            }
        }
        return cnt;
    }
}

