import java.util.*;
import java.io.*;

/*
1. 입력을 받을때 익은 토마토 + 빈칸 수 구하기
2. 입력개수와 1에서 받은 개수가 일치할 경우 0 리턴
3. bfs()돌리기
 

*/
public class Main {
    
    private static int row;
    private static int col;
    private static int[][] map;
    private static boolean[][] visited;
    private static int curCnt=0;
    private static int dx[] = {0,0,-1,1};
    private static int dy[] = {1,-1,0,0};
    private static Queue<int[]> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(map[i][k]==1){
                    curCnt++;
                    visited[i][k] = true;
                    //행 / 열
                    que.add(new int[]{i,k,0});
                }
                else if(map[i][k]==-1)curCnt++;

            }
        }
        if(curCnt==row*col){
            System.out.print(0);
            System.exit(0);
        }
        
        int result = bfs();
   
        System.out.println(result);
    }
    
    public static int bfs(){
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int i=0;i<4;i++){
                int newY = cur[0]+dy[i]; // 행
                int newX = cur[1]+dx[i]; // 열
                if(newX>=0&&newX<col&&newY>=0&&newY<row&&!visited[newY][newX]&&map[newY][newX]==0){
                    que.add(new int[]{newY,newX,cur[2]+1});
                    visited[newY][newX] = true;
                    curCnt++;
                    if(curCnt==row*col){
                        return cur[2]+1;
                    }
                }
            }
        }
        
        return -1;
        
    }
}
