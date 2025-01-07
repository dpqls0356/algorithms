import java.util.*;
import java.io.*;

public class Main {
    
    private static ArrayList<Integer> inputArr;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = 0;
        
        do{
            st = new StringTokenizer(br.readLine());
            
            size = Integer.parseInt(st.nextToken());
            
            inputArr = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                inputArr.add(Integer.parseInt(st.nextToken()));    
            }
            
            arr = new int[inputArr.size()];
            
            combination(0,0);
            
            sb.append("\n");
            
        }while(size!=0);
        
        System.out.print(sb.toString());
        
    }
    
    public static void combination(int depth,int beforeIndex){
        if(depth==6){
            for(int i=0;i<6;i++){
                sb.append(arr[i]+" ");
            }
           sb.append("\n");
        }
        else{
            for(int i = beforeIndex;i<inputArr.size();i++){
                arr[depth] = inputArr.get(i);
                combination(depth+1,i+1);
            }
        }
    }
}
