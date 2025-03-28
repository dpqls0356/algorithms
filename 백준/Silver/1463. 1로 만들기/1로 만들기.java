import java.util.*;
import java.io.*;

public class Main {
    private static int start;
    private static int[] cost;
    private static Queue<int[]> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        
        if(start==1){
            System.out.println(0);
            return;
        }
        
        que.add(new int[]{start,0});
        
        cost = new int[1000001];
        for(int i=0;i<cost.length;i++){
            cost[i] = Integer.MAX_VALUE;
        }
        
        cost[start] = 0;
        
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int pos = cur[0];
            int cnt = cur[1];
            if(pos%3==0){
                if(pos/3==1){
                    System.out.print(cnt+1);
                    return ;
                }
                if(cost[pos/3]>cnt+1){
                    que.add(new int[]{pos/3,cnt+1});
                    cost[pos/3] = cnt+1;
                }
            }
            if(pos%2==0){
                if(pos/2==1){
                    System.out.print(cnt+1);
                    return ;
                }
                if(cost[pos/2]>cnt+1){
                    que.add(new int[]{pos/2,cnt+1});
                    cost[pos/2] = cnt+1;
                }
            }
            if(pos-1>0){
                if(pos-1==1){
                    System.out.print(cnt+1);
                    return ;
                }
                if(cost[pos-1]>cnt+1){
                    que.add(new int[]{pos-1,cnt+1});
                    cost[pos-1] = cnt+1;
                }
            }
        }
    }
}
