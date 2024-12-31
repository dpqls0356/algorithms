import java.util.*;
import java.io.*;

public class Main {
    /*
        일곱난쟁이의 합 == 100
        난쟁이의 수 = 7    
    */
    private static int[] inputArr = new int[9];
    private static int[] result = new int[7];
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i=0;i<9;i++){
             st = new StringTokenizer(br.readLine());
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(inputArr);
        
        findMyNanJangYi(0,0,0);
        
       
        
    }
    public static void findMyNanJangYi(int depth,int height,int beforeIndex){
        if(depth==7&&height==100){
            for(int i=0;i<7;i++){
                sb.append(result[i]+"\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
        else if(depth<7){
            for(int i = beforeIndex;i<9;i++){
                int newHeight = height+inputArr[i];
                if(newHeight<=100){
                    result[depth] = inputArr[i];
                    findMyNanJangYi(depth+1,newHeight,i+1);
                }
            }
        }
    }
}