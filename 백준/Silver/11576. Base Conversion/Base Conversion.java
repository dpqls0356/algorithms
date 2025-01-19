import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int size = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> inputArr = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<size;i++){
            inputArr.add(Integer.parseInt(st.nextToken()));
        }
        
        int num = 0 ;
        
        for(int i=0;i<size;i++){
            num += inputArr.get(size-1-i)*Math.pow(A,i);
        }
        
        while(num>=B){
            sb.insert(0," "+num%B);
            num/=B;
        }
        if(num!=0){
            sb.insert(0,num);
        }
        else{
            sb.delete(0,1);
        }
        
        System.out.print(sb.toString());
    }
}
