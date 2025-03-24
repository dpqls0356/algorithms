import java.util.*;
import java.io.*;

public class Main {
    
    private static int N,M;
    private static int cnt;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx  = { 0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException  {
        
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        while(T>0){
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new char[N][M];
            visited = new boolean[N][M];
            cnt = 0;
            
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int k=0;k<M;k++){
                    map[i][k] = str.charAt(k);
                }
            }
            
            for(int i = 0;i<N;i++){
                for(int k=0;k<M;k++){
                    if(map[i][k] == '#'&&!visited[i][k]){
                        dfs(i,k);
                        cnt++;
                    }
                }
            }
            sb.append(cnt+"\n");
            T--;
        }
        System.out.print(sb.toString());
        
    }
    
    public static void dfs(int y,int x){
        visited[y][x] = true;
        for(int i=0;i<dy.length;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny>=0&&ny<N&&nx>=0&&nx<M&&!visited[ny][nx]&&map[ny][nx]=='#'){
                dfs(ny,nx);
            }
        }
    }
}
