import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        ArrayList<Integer> arr = new  ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        String inputNums = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        
        for(int i=0;i<inputNums.length();i++){
            char num = inputNums.charAt(inputNums.length()-1-i);
            if((int)num>=65){
                arr.add(num-55);
            }
            else{
                arr.add(num-'0');
            }
        }
        
        long result = 0;
        for(int i=0;i<inputNums.length();i++){
            result+=arr.get(i)*Math.pow(N,i);
        }
        
        System.out.print(result);
        
    }
}
