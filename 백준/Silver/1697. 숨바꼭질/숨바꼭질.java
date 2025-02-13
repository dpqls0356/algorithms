import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int su = sc.nextInt();
        int sister = sc.nextInt();
        
        Queue<int[]> que = new LinkedList<>();
        boolean[] visited = new boolean[1_000_001];
        
        que.add(new int[]{su,0}); // 수빈 위치 / 시간
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0]==sister){
                System.out.println(cur[1]);
                System.exit(0);
            }
            else{
                int next[] = new int[] {cur[0]+1,cur[0]*2,cur[0]-1};
                for(int i=0;i<3;i++){
                    if(next[i]>=0&&next[i]<=1_000_000&&!visited[next[i]]){
                        visited[next[i]] = true;
                        que.add(new int[]{next[i],cur[1]+1});
                    }
                }
            }
        }

    }
}
