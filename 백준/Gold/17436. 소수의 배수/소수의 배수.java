import java.util.*;
import java.io.*;
public class Main {
    
    private static int N;
    private static long M;
    private static long[] inputArr;
    private static long[] selected;
    private static long count = 0;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        inputArr = new long[N];
        selected = new long[N];
        for(int i=0;i<N;i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            cal(i,0,0);
        }
        System.out.print(count);
    }
    public static void cal(int selectCnt,int currentCnt,int beforeIndex){
        if(selectCnt==currentCnt){
            if(selectCnt==1){
                count += M/selected[0];
            }
            else{
                long sum = 1;
                for(int i=0;i<selectCnt;i++){
                    sum *=selected[i];
                }
                if(selectCnt%2==0){
                    count-=M/sum;
                }
                else{
                   count+=M/sum;
                }
            }
        }
        else{
            for(int i=beforeIndex;i<N;i++){
                selected[currentCnt] = inputArr[i];
                cal(selectCnt,currentCnt+1,i+1);
            }
        }
    }

}
