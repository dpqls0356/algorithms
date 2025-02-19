import java.util.*;
import java.io.*;

/*
불은 매초 동서남북으로 퍼짐
벽에 불이 붙지않음
상근이는 동서남북 인접한 칸으로 이동하며 1초가 걸림 
    => 벽 통과 불가
    => 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동 못함 : 불이 먼저 이동한다는 이야기
얼마나 빨리 탈출하는가 => bfs 최단거리

. 빈공간
# 벽
@ 상근위치
* 불

*/
public class Main {
    
    private static int rangeY;
    private static int rangeX;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static StringBuilder sb = new StringBuilder();
    private static Queue<int[]> sangQue;
    private static Queue<int[]> fireQue;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        while(T>0){
            
            st = new StringTokenizer(br.readLine());
            rangeX = Integer.parseInt(st.nextToken());
            rangeY = Integer.parseInt(st.nextToken());
            
            setArray();
            
            for(int i=0;i<rangeY;i++){
                String str = br.readLine();
                for(int k=0;k<rangeX;k++){
                    map[i][k] = str.charAt(k);
                    if(map[i][k]=='#'){
                        visited[i][k] = true;
                    }
                    else if(map[i][k]=='@'){
                        sangQue.add(new int[]{i,k,0});
                        visited[i][k] = true;
                    }
                    else if(map[i][k]=='*'){
                        fireQue.add(new int[]{i,k,0});
                        visited[i][k] = true;
                    }
                }
            }
            
            int result = bfs();
            if(result==-1){
                sb.append("IMPOSSIBLE\n");
            }
            else sb.append((result+1)+"\n");
            
            T--;
        }
        
        System.out.print(sb.toString());
    }
    
    public static void setArray(){
        visited = new boolean[rangeY][rangeX];
        map = new char[rangeY][rangeX];
        sangQue = new LinkedList<>();
        fireQue = new LinkedList<>();
    }
    
    public static int bfs(){
        
        while(!sangQue.isEmpty()){
            
            int[] sang = sangQue.poll();
            if(sang[0]==0||sang[0]==rangeY-1||sang[1]==0||sang[1]==rangeX-1)return sang[2];
            
            fireBfs(sang[2]);
            
            for(int i=0;i<4;i++){
                int y = sang[0]+dy[i];
                int x = sang[1]+dx[i];
                if(y>=0&&y<rangeY&&x>=0&&x<rangeX&&!visited[y][x]){
                    sangQue.add(new int[]{y,x,sang[2]+1});
                    visited[y][x] = true;
                }
            }
        }
        
        return -1;
    }
    
    public static void fireBfs(int time){
        while(!fireQue.isEmpty()){
            
            int[] fire = fireQue.poll();
            
            if(fire[2]!=time){
                fireQue.add(fire);
                return;
            }
            
            for(int i=0;i<4;i++){
                int y = fire[0]+dy[i];
                int x = fire[1]+dx[i];
                if(y>=0&&y<rangeY&&x>=0&&x<rangeX&&!visited[y][x]){
                    fireQue.add(new int[]{y,x,fire[2]+1});
                    visited[y][x] = true;
                }
            }
        }
    }
}
