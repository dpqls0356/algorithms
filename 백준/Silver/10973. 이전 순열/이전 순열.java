import java.util.*;
import java.io.*;

public class Main {
    
    private static int size;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        size = Integer.parseInt(st.nextToken());
        int[] arr = new int[size+1];
        
        st =  new StringTokenizer(br.readLine());
        for(int i = 1; i<size+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int top = size;
        while(top>0&&arr[top]>=arr[top-1]){
            top--;
        }
        if(top==0){
            System.out.print("-1");
            System.exit(0);
        }
        
        int targetIndex = 0;
        for(int i=size;i>=top;i--){
            if(arr[top-1]>arr[i]){
                targetIndex = i;
                break;
            }
        }
        
        int temp = arr[top-1];
        arr[top-1] = arr[targetIndex];
        arr[targetIndex] = temp;
        

        int left = top;
        int right = size;
        while(left<right){
            int swap = arr[left];
            arr[left] = arr[right];
            arr[right] = swap;
            left++;
            right--;
        }
        
        for(int i=1;i<=size;i++){
            System.out.print(arr[i]+ " " );
        }
    }
}
