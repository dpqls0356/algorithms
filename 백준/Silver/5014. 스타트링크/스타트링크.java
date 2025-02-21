import java.util.*;
import java.io.*;

public class Main {
    
    private static int size,gang,destination,up,down;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        size = Integer.parseInt(st.nextToken());
        gang = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        
        visited = new boolean[2000001];
        
        if(gang==destination){
            System.out.print(0);
            System.exit(0);
        }
        
        int result = bfs();
        
        if(result == -1){
            System.out.print("use the stairs");
        }
        else{
            System.out.print(result);
        }
    }
    
    public static int bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{gang,0});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0]==destination){
                return cur[1];
            }
            else{
                int moveUp = cur[0] + up;
                //빼기를 안함
                int moveDown = cur[0] - down;
                if(moveUp>=1&&moveUp<=size&&!visited[moveUp]){
                    que.add(new int[]{moveUp,cur[1]+1});
                    visited[moveUp] = true;
                }
                if(moveDown>=1&&moveDown<=size&&!visited[moveDown]){
                    que.add(new int[]{moveDown,cur[1]+1});
                    visited[moveDown] = true;
                }
            }
        }
        
        return -1;
    }
}
