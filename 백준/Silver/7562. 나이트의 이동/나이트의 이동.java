import java.util.*;
import java.io.*;
/*
나이트가 이동하려는 하는 칸이 주어지고 몇 번 움직여서 이 칸으로 갈 수 있는지 판단하는 문제
이동경로는 8개
x,y
(-1,2)
(-2,1)
(1,2)
(2,1)
(-2,-1)
(-1,-2)
(1,-2)
(2,-1)

입력 : 
테케
한변의 길이
현재위치
가려는위치 

최단 거리 -> bfs
*/

public class Main {

    private static boolean[][] visited;
    private static int N;
    private static StringBuilder sb = new StringBuilder();
    private static int[] dy = {2,  1,  2,  1,  -1,  -2,  -2,  -1};
    private static int[] dx = {-1, -2,  1,  2,  -2,  -1,  1,  2};


    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while(T>0){
            
            N = Integer.parseInt(br.readLine());
            setVisited(N);
            
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());    
            
            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            
            int result = bfs(startY,startX,endY,endX);
            sb.append(result+"\n");
            
            T--;
        }
        
        System.out.print(sb.toString());
        
    }
    
    public static void setVisited(int n){
        visited = new boolean[n][n];
    }
    
    public static int bfs(int startY,int startX,int endY,int endX){
        
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{startY,startX,0});
        visited[startY][startX] = true;
        
        while(!que.isEmpty()){
            int cur[] = que.poll();
            if(cur[0]==endY&&cur[1]==endX){
                return cur[2];
            }
            for(int i=0;i<dx.length;i++){
                int y = cur[0]+dy[i];
                int x = cur[1]+dx[i];
                if(x>=0&&x<N&&y>=0&&y<N&&!visited[y][x]){
                    visited[y][x] = true;
                    que.add(new int[]{y,x,cur[2]+1});
                }
            }
        }
        
        return 0;
    }
}
