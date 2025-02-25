import java.util.*;
import java.io.*;

/*
0은 바다 나머지는 빙산
일년마다 동서남북 방향으로 테두리만 사라짐

두덩어리로 분리되는 최소 시간

bfs 녹이고 -> dfs 덩어리 개수 카운트

배열의 최대 크기 N M = 300*300 = 90000 9만 흠 1억번 
*/
public class Main {
    
    private static int map[][];
    private static int memo[][];
    private static int row,col;
    private static Queue<int[]> que = new LinkedList<>(); // y,x,year
    private static boolean[][] visited;
    private static int ice = 0;
    private static int year = 0;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());     
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        memo = new int[row][col];
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                memo[i][k] = map[i][k];
                if(map[i][k]!=0){
                    que.add(new int[]{i,k,0});
                    ice ++;
                }
            }
        }
        //빙산이 없는 경우
        if(ice==0){
            System.out.print(0);
            System.exit(0);
        }
        
        int result = bfs();
        
        if(result == -1){
            System.out.print(0);
        }else System.out.print(result);
    }
    
    public static int bfs(){
        
        while(!que.isEmpty()){
                
            int[] cur = que.poll();           
            // 다음 년도로 넘어간 경우 dfs 돌려서 빙산 덩어리 개수 체킹
            if(cur[2]!=year){
                // System.out.println("year: "+ year);
                //큐에 넣기 -> 다음에 돌려야함
                que.add(cur);
                
                // 지도 복사하기
                for(int i = 0;i<row;i++){
                    System.arraycopy(memo[i],0, map[i], 0,col); 
                }
                
                //dfs 돌려서 빙산 덩어리 개수 체킹
                int cnt = 0;
                visited = new boolean[row][col];
                for(int i=0;i<row;i++){
                    for(int k=0;k<col;k++){
                        // System.out.print(map[i][k]+" ");
                        if(!visited[i][k]&&map[i][k]>0){
                            dfs(i,k);
                            cnt++;
                        }
                    }
                    // System.out.println();
                }
                // 두 덩어리 이상이면 리턴
                if(cnt>=2){
                    return cur[2];
                }
                // 아니면 년도 높여주기
                else{
                    year++;
                }
            }
             // 현재 년도인 경우 빙산 녹이기
            else{
                //물이 있는 곳이 있는지 판단
                int water = 0;
                for(int i = 0 ; i<4;i++){
                    int y = cur[0]+dy[i];
                    int x = cur[1]+dx[i];
                    if(map[y][x]<=0)water++;
                }
                if(cur[0]==2&&cur[1]==4){
                    // System.out.println("water: "+water);
                }
                //물과 닿아있는 경우
                if(water!=0){
                    memo[cur[0]][cur[1]] -=water;
                    if(memo[cur[0]][cur[1]]<0)memo[cur[0]][cur[1]]=0;
                    //빙산이라면
                    if( memo[cur[0]][cur[1]] != 0 ){
                        que.add(new int[]{cur[0],cur[1],cur[2]+1});
                    }
                }
                //물과 닿지않는 경우
                else{
                  que.add(new int[]{cur[0],cur[1],cur[2]+1});
                }
                
            }
           
        }
        return -1;
    }
    
    public static void dfs(int y,int x){
        
        for(int i=0;i<4;i++){
            int newY = y+dy[i];
            int newX = x+dx[i];
            if(newY>=0&&newX>=0&&newY<row&&newX<col&&!visited[newY][newX]&&map[newY][newX]>0)
            {
                visited[newY][newX] = true;
                dfs(newY,newX);
            }
        }
    }
}
