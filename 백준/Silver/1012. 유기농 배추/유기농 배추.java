import java.util.*;
import java.io.*;
//상하좌우로 이동
//배추가 모여있는 곳에 한마리만 있으면 된다. => 구역찾기 dfs or bfs 둘 다 상관없을 듯?
//배열 써도 되지만 arrayList써서 간선만 넣어도 될듯?

public class Main {
    
    public static int[][] map;
    public static boolean[][] visited;
    public static int row;
    public static int col;
    public static int[] dx = {0,0,-1,1}; //레전드 0,0,-1,0으로 해버림 ;;
    public static int[] dy = {1,-1,0,0};
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        while(T>0){
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int inputSize = Integer.parseInt(st.nextToken());
            
            map = new int[row][col];
            visited = new boolean[row][col];
            
            for(int i=0;i<inputSize;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1; // x = 열 / y = 행
            }
            
            // System.out.println("======================");
            // for(int i=0;i<row;i++){//y
                // for(int k=0;k<col;k++){ //x
                    // System.out.print(map[i][k]+" ");
                // }
                // System.out.println();
            // }
            
            int count = 0;
            for(int i=0;i<row;i++){//y
                for(int k=0;k<col;k++){ //x
                    if(!visited[i][k]&&map[i][k]==1){
                        count++;
                        // System.out.println(i+" "+k);
                        dfs(i,k); // 행 - 열
                    }
                }
            }
            
            sb.append(count+"\n");
            
            T--;
        }
        
        System.out.print(sb.toString());
    }
    //행 - 열
    public static void dfs(int curY,int curX){
        for(int i=0;i<4;i++){
            int x = curX+dx[i]; // 열
            int y = curY+dy[i]; // 행
            if(x>=0&&x<col&&y>=0&&y<row&&map[y][x]==1&&!visited[y][x]){
                visited[y][x] = true;
                dfs(y,x);
            }
        }
    }
}
