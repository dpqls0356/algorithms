import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] permuation;
    private static boolean[] visited;
    private static int maxSum = Integer.MIN_VALUE;
    private static List<Integer> inputArr = new ArrayList<>();
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        permuation = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            inputArr.add(Integer.parseInt(st.nextToken()));
        }
        
        inputArr.sort(Comparator.naturalOrder());
        
        findMaxSum(0);
        
        System.out.print(maxSum);
        
    }
    public static void compareSum(){
        int sum = 0;
        int index = 0;
        
        while(index<=N-2){
            if(permuation[index]>permuation[index+1])
                sum+=(permuation[index]-permuation[index+1]);
            else
                sum+=(permuation[index+1]-permuation[index]);
            index++;
        }
        
        if(sum>maxSum)maxSum = sum;
        
    }
    public static void findMaxSum(int depth){
        if(depth==N){
            compareSum();
        }
        else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i]= true;
                    permuation[depth] = inputArr.get(i);
                    findMaxSum(depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}
