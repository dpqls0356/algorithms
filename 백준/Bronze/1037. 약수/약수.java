import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[size+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=size;i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        } 
        Arrays.sort(arr);
        
        if(size==1){
            System.out.print(arr[1]*arr[1]);
            System.exit(0);
        }
        
        int[] useArr = new int[size+1];
        for(int i=1;i<=size/2;i++){
            useArr[i] = arr[i];
            useArr[size-i+1] = arr[size-i+1];
        }
        if(size%2!=0){
            useArr[size/2+1] = arr[size/2+1];
        }

        long result;
        
        if(size%2==0){
            result = useArr[size/2]*useArr[size/2+1];
        }
        else{
            result = useArr[size/2+1]*useArr[size/2+1];
        }
        
        System.out.print(result);

    }
}
