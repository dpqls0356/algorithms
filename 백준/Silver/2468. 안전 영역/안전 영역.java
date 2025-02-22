import java.util.*;
import java.io.*;

/*
물에 잠기지않는 안전 영역 개수
N*N 

*/
public class Main {
    
    private static int N;
    private static int maxCnt = Integer.MIN_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    private static ArrayList<Integer> height = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                if(!height.contains(map[i][k]))height.add(map[i][k]);
            }
        }
        
        height.add(0);
        for(int i=0;i<height.size();i++){
            visited = new boolean[N][N];
            int cnt = 0;
             // System.out.println(height.get(i));
            for(int k=0;k<N;k++){
                for(int j=0;j<N;j++){
                    if(map[k][j]>height.get(i)&&!visited[k][j]){
                        dfs(k,j,height.get(i));
                        cnt++;
                    }

                }
            }
            if(cnt>maxCnt)maxCnt = cnt;
        }
        System.out.print(maxCnt);
    }
    
    public static void dfs(int y,int x, int waterHeight){
        visited[y][x] = true;
        
        for(int i=0;i<4;i++){
            int newY = y +dy[i];
            int newX = x +dx[i];
            if(newX>=0&&newX<N&&newY>=0&&newY<N&&map[newY][newX]>waterHeight&&!visited[newY][newX]){
                dfs(newY,newX,waterHeight);
            }
        }
    }
}
