import java.util.*;
import java.io.*;

/*
N M 행렬 맵
이동 0
1 벽
1,1 에서 N,M으로 이동 하는데 최단 경로로 이동하기 + 시작칸과 끝나는 칸도 세어야한다.
벽 하나 부시는 거 가능

음 큐에 y,x,이동횟수,벽부수기 가능 여부를 int(true = 1 , false = 0)값으로 넣어서
true이면 막힌 벽도 이동 가능하게 하고 아닌 경우엔 벽은 못지나가게 하기 ? 

반례
벽을 부순 세계와 벽을 부수지않은 세계를 함께 visited를 관리하게되면

5 4
0000
1000
0000
1111
0000

다음과 같은 케이스에 통과를 하지 못하게 된다.
그렇기에 분리해서 방문을 관리해아함 



*/
public class Main {
    
    private static int row;
    private static int col;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        visited = new boolean[row][col][2]; // 0 이 벽을 이미 부순 세계  / 1 이 벽을 아예 안 부순 세계
        
        for(int i=0;i<row;i++){
            String str = br.readLine();
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(str.charAt(k)+"");
            }
        }
        
        int result = bfs();
        
        System.out.println(result);
        
    }
    
    public static int bfs(){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,1,1});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0]==row-1&&cur[1]==col-1){
                return cur[2];
            }
            for(int i=0;i<4;i++){
                int y = cur[0]+dy[i];
                int x = cur[1]+dx[i];
                if(y>=0&&y<row&&x>=0&&x<col){
                    // 벽을 부순 경우 -> 옮길 위치가 벽이 아니고 안부순세계에서 방문 안한 경우
                    // 벽을 부수지않은 경우 -> 옮길 위치가 벽이고 부순 세계에서 방문을 안한 경우 / 옮길 위치가 빈공간이고 안부순 세계에서 방문을 안한 경우
                    //벽을 안부순 경우
                    if(cur[3]==1){
                        //벽을 부수지않고 이동
                        if(map[y][x]==0&&!visited[y][x][1]){
                             visited[y][x][1] = true;
                             que.add(new int[]{y,x,cur[2]+1,cur[3]});
                        }
                        //벽을 부수고 이동
                        else if(map[y][x]!=0&&!visited[y][x][0]){
                             visited[y][x][0] = true;
                             que.add(new int[]{y,x,cur[2]+1,0});
                        }
                    }
                    // 벽을 부순 경우
                    else if(cur[3]==0){
                        if(map[y][x]==0&&!visited[y][x][0]){
                             visited[y][x][0] = true;
                             que.add(new int[]{y,x,cur[2]+1,cur[3]});
                        }
                    }
                    // if(map[y][x]==0){ //빈공간
                        // if(!visited[y][x][cur[3]]){
                            // que.add(new int[]{y,x,cur[2]+1,cur[3]});
                            // visited[y][x] = true;
                        // }
                    // }
                    // else{ //벽
                        // if(cur[3]==1&&!visited[y][x]){
                            // que.add(new int[]{y,x,cur[2]+1,0});
                            // visited[y][x] = true;
                        // }
                    // }   
                }

            }
        }
        return -1;
    }
}
