import java.util.*;
import java.io.*;

public class Main {

    private static int row,col,K;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int [row][col];
        visited = new boolean[row][col][K+1]; //0 ~ K까지
        
        for(int i=0;i<row;i++){
            String str = br.readLine();
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(str.charAt(k)+"");
            }
        }
        
        int result = bfs();
        
        System.out.print(result);
    }
    
    public static int bfs(){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,1,0}); // y,x,move,벽을 부순 횟수
        visited[0][0][0] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0]==row-1&&cur[1]==col-1){
                return cur[2];
            }
            for(int i=0;i<4;i++){
                int x = cur[1]+dx[i];
                int y = cur[0]+dy[i];
                //벽일때 + 부술 수 있을 때 + 방문하지않을 곳일때 - 아오 cur[3]+1<=K 이걸 <로 만 해둠 ;;
                if(y>=0&&y<row&&x>=0&&x<col&&cur[3]+1<=K&&!visited[y][x][cur[3]+1]&&map[y][x]==1){
                        que.add(new int[]{y,x,cur[2]+1,cur[3]+1});
                        visited[y][x][cur[3]+1] = true;
                }
                //벽이 아닐때 + 방문한 적이 없을때
                else if(y>=0&&y<row&&x>=0&&x<col&&!visited[y][x][cur[3]]&&map[y][x]==0){
                    que.add(new int[]{y,x,cur[2]+1,cur[3]});
                    visited[y][x][cur[3]] = true;
                }

            }
        }
        return -1;
    }
}
