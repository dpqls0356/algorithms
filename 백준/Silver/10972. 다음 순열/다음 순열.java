import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            
            st = new StringTokenizer(br.readLine());
            
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int top = N-1;
            while(top>0&&arr[top]<arr[top-1]){
                    top--;
            }
            if(top==0){
                System.out.print("-1");
                System.exit(0);
            }
            
            int temp = arr[top-1];
            for(int i=N-1;i>-1;i--){
                if(temp<arr[i]){
                    arr[top-1] = arr[i];
                    arr[i]=temp;
                    break;
                }
            }
            
    // top뒤부터 정렬하기
					    int left = top;
					    int right = N-1;
					    while(left<right){
					        int swap = arr[left];
					        arr[left] = arr[right];
					        arr[right] = swap;
					        left++;
					        right--;
					    }
    
            
            for(int i=0;i<N;i++){
                System.out.print(arr[i]+" ");
            }
            
    }
}
