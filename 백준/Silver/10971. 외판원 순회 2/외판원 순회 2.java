import java.util.*;
import java.io.*;

public class Main {
    
    private static int N; //크기
    private static int[][] costs; //비용
    private static ArrayList<Integer>[] edge; //간선
    private static boolean[] visited; // 가는길 체킹
    private static int minCost = Integer.MAX_VALUE; // 금액
    private static int start;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        costs = new int[N][N];
        edge = new ArrayList[N];
        for(int i=0;i<N;i++){
            edge[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                int cost = Integer.parseInt(st.nextToken());
                costs[i][k] = cost;
                if(cost!=0){
                    edge[i].add(k);
                }
            }
        }
        
        //갈때 최소비용
        for(int i=0;i<N;i++){
            start = i;
            dfs(i,1,0);
        }
        System.out.print(minCost);
        
    }
    
    //확인 노드, 거쳐간 도시 수 , 비용
    public static void dfs(int node,int cnt,int curCost){
        if(cnt==N){
            //1.현재 노드가 시작점으로 연결이 되어있는지 확인
            //2. 그 금액이 최소금액보다 작은지 확인
            if(edge[node].indexOf(start)!=-1){
                if(curCost+costs[node][start]<minCost)minCost = curCost+costs[node][start];
            }           
        }else{
            visited[node] =true;
            for(int i=0;i<edge[node].size();i++){
                if(!visited[edge[node].get(i)]){
                    dfs(edge[node].get(i),cnt+1,curCost+costs[node][edge[node].get(i)]);
                }
            }
            visited[node] = false;
        }
    }
    
}
