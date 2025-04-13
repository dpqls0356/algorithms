import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] route;
    private static Queue<int[]> que = new PriorityQueue<>((a,b)->a[1]-b[1]); // int[] = {현재 위치 , 움직인 횟수};
    private static boolean[] visited;
    private static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        route = new int[N+1];
        visited = new boolean[N+1];
        
        que.add(new int[]{N,0});
        visited[N] = true;
        route[N] = 1; // 루트 출력 시 반복문을 사용할텐데 끝을 알아야하기때문
        
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int pos = cur[0];
            int cnt = cur[1];
            
            if(pos==1){
                list.add(pos);
                int ins = 1;
                while(route[ins]!=1){
                    ins = route[ins];
                    list.add(ins);
                }
                System.out.println(cnt);
                for(int i = list.size()-1;i>=0;i--){
                    System.out.print(list.get(i)+" ");
                }
            }
            else{
                //나눠 떨어지고 방문하지않은 경우
                if(pos%3==0&&!visited[pos/3]){
                    que.add(new int[]{pos/3,cnt+1});
                    route[pos/3] = pos;
                    visited[pos/3] = true;
                }
                if(pos%2==0&&!visited[pos/2]){
                    que.add(new int[]{pos/2,cnt+1});
                    route[pos/2] = pos;
                    visited[pos/2] = true;
                }
                if(pos-1>0&&!visited[pos-1]){
                    que.add(new int[]{pos-1,cnt+1});
                    route[pos-1] = pos;
                    visited[pos-1] = true;
                }
            }
        }
        
    }
}
