import java.util.*;
import java.io.*;

public class Main {
    
    private static ArrayList<Integer>[] list;
    private static int node;
    private static int edge;
    private static boolean visited[];
    private static int cnt = 0;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        node =Integer.parseInt(br.readLine());
        edge =Integer.parseInt(br.readLine());
        
        list = new ArrayList[node+1];
        visited = new boolean[node+1];
        
        for(int i=0;i<=node;i++){
          list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge;i++){
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        visited[1] = true;
        dfs(1);
        System.out.print(cnt);
    }
    
    public static void dfs(int node){
        for(int i=0;i<list[node].size();i++){
            if(!visited[list[node].get(i)]){
                cnt++;
                visited[list[node].get(i)] = true;
                dfs(list[node].get(i));
            }
        }
    }
}
