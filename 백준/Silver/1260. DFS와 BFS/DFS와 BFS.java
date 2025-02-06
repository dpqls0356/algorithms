import java.util.*;
import java.io.*;

public class Main {
    
    private static int edge;
    private static int node;
    private static boolean visited[];
    private static ArrayList<Integer>[] dfsArr;
    private static ArrayList<Integer>[] bfsArr;
    private static int start;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br;
    private static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        
        setArr();
        setVisitedArr();
        inputInfo();
        sortArr();
        
        sb.append(start+" ");
        visited[start] = true;
        dfs(start);
        
        sb.append("\n");
        
        setVisitedArr();
        
        bfs(start);
        
        System.out.println(sb.toString());
            
    }
    
    public static void setArr(){
        
        dfsArr = new ArrayList[node+1];
        bfsArr = new ArrayList[node+1];
        
        for(int i=0;i<=node;i++){
            dfsArr[i] = new ArrayList<Integer>();
            bfsArr[i] = new ArrayList<Integer>();
        }
        
    }
    
    public static void setVisitedArr(){
        visited = new boolean[node+1];
    }
    
    public static void inputInfo() throws IOException {
        
        for(int i=0;i<edge;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bfsArr[a].add(b);
            bfsArr[b].add(a);
            dfsArr[a].add(b);
            dfsArr[b].add(a);
        }
    }
    
    public static void sortArr(){
        for(int i=1;i<=node;i++){
            Collections.sort(bfsArr[i]);
            Collections.sort(dfsArr[i]);
        }
    }
    
    public static void dfs(int n){
        for(int i=0;i<dfsArr[n].size();i++){
            if(!visited[dfsArr[n].get(i)]){
                visited[dfsArr[n].get(i)] = true;
                sb.append(dfsArr[n].get(i)+" ");
                dfs(dfsArr[n].get(i));
            }
        }
    }
    
    public static void bfs(int n){
        Queue<Integer> que =  new LinkedList<>();
        visited[n] = true;
        que.add(n);
        
        while(!que.isEmpty()){
            int num = que.poll();
            sb.append(num+" ");
            for(int i=0;i<bfsArr[num].size();i++){
                if(!visited[bfsArr[num].get(i)]){
                    visited[bfsArr[num].get(i)] = true;
                    que.add(bfsArr[num].get(i));
                }
            }
        }
        
    }
    
}
