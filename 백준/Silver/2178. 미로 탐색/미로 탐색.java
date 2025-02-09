import java.util.*;
import java.io.*;


public class Main {
    
    private static int row;
    private static int col;
    //상하좌우
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] visited;
    private static int[][] map;
    private static int[][] memo;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        memo = new int[row][col];
        visited = new boolean[row][col];
        
        for(int i=0;i<row;i++){
            String str = br.readLine();
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(str.charAt(k)+"");
                memo[i][k] = Integer.MAX_VALUE;
            }
        }
        
        memo[0][0] = 1;
        
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(!visited[i][k]&&map[i][k]==1){
                    dfs(i,k);
                }
            }
        }
        
        System.out.print(memo[row-1][col-1]);
        
    }
    
    public static void dfs(int x,int y){
            for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
                if(newX>=0&&newX<row&&newY>=0&&newY<col&&!visited[newX][newY]&&map[newX][newY]==1){
                    int num = memo[x][y]+1;
                    if(memo[newX][newY]>num){
                        memo[newX][newY] = num;
                        visited[newX][newY] = true;
                        dfs(newX,newY);
                        visited[newX][newY] = false;
                    }
                }
         
            }
    }
}
