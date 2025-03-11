import java.io.*;
import java.util.*;

public class Main {
    //방법1
    //테두리 일 경우 bfs돌리기 ?
    //단 최소 거리보다 짧아야함
    
    //방법2
    // 아니면 테두리들을 전부 다 넣어놓고 bfs 돌리기 ?
    // 이렇게되면 방문처리를 하기가 너무 까다로움 
    private static int[][] map;
    private static boolean[][] visited;
    private static int N;
    private static int[] dy = {1,-1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static int minDis = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                map[i][k] = Integer.parseInt(st.nextToken ());
            }
        }
        //map의 섬마다 숫자를 바꿔주기 1번섬 / 2번섬 / ..
        int cnt = 1;
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(!visited[i][k]&&map[i][k]==1){
                    exploreIsland(i,k,cnt);
                    cnt++;
                }
            }
        }

        //최단거리 찾기
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(map[i][k]!=0){
                    boolean isSide = false;
                    for(int j=0;j<dy.length;j++){
                        int y = i+dy[j];
                        int x = k+dx[j];
                        if(y>=0&&y<N&&x<N&&x>=0&&map[y][x]==0){
                            isSide = true;
                            break;
                        }
                    }
                    //테두리의 부분일 경우 dfs돌리기
                    if(isSide){
                        visited = new boolean[N][N];
                        bfs(i,k,map[i][k]);
                    } 
                }
            }
        }
        System.out.print(minDis);
    }
    public static void exploreIsland(int y,int x,int num){
        visited[y][x] = true;   
        map[y][x] = num;
        for(int i=0;i<dy.length;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX>=0&&newX<N&&newY>=0&&newY<N&&!visited[newY][newX]&&map[newY][newX]==1){
                exploreIsland(newY,newX,num);
            }
        }
        
    }
    
    public static void bfs(int startY,int startX, int startIsland){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startY,startX,0});
        
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int curY = cur[0];
            int curX = cur[1];
            int move = cur[2];
            if(move<minDis){
                for(int i=0;i<dy.length;i++){
                    int x = curX + dx[i];
                    int y = curY + dy[i];
                    if(x>=0&&x<N&&y>=0&&y<N&&!visited[y][x]){
                        //계속 다리 이어가기
                        if(map[y][x]==0){
                            visited[y][x] = true;
                            que.add(new int[]{y,x,move+1});                        
                        }
                        //다리 짓기 완료
                        else if(map[y][x]!=startIsland&&map[y][x]!=0){
                            minDis = move;
                            return;
                        }
                    }
                }
            }

        }
    }
}
