import java.io.*;
import java.util.*;


public class Main {
            
    private static ArrayList<Long> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long inputSize = Long.parseLong(st.nextToken());
        long subeen =  Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<inputSize;i++){
            long inputNum =  Long.parseLong(st.nextToken());
            arr.add(Math.abs(inputNum-subeen));
        }
        
        long result = arr.get(0);
        
        for(int i=1;i<inputSize;i++){
            result = gdc(result,arr.get(i));
        }
        
        System.out.print(result);
    }
    
    public static long gdc(long a,long b){
        if(b==0)return a;
        else return gdc(b,a%b);
    }
}
