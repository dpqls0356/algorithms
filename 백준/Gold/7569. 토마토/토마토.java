import java.util.*;
import java.io.*;
/*
    m 가로 col
    n 세로 row
    h 높이
    1000000 => 탐색할 칸의 수 
    1 익음 / 0 안익음 / -1 토마토 없음
    
    1. 입력받으면서 익은 토마토와 토마토가 없는 경우를 카운트 - 가장 밑부터 받음 !!! 
    2. 토마토 퍼트리기 [ h,y,x,day ]
        퍼트리면서 1에서 카운트한 수에 ++ 하기 => 만약 이 수가 col*row*h라면 day출력하고 끝내기
    
*/
public class Main {
  
    private static int col;
    private static int row;
    private static int height;
    private static int[][][] map;
    private static boolean[][][] visited;
    private static int cnt = 0;
    private static int dx[] = {0,0,0,0,-1,1};
    private static int dy[] = {0,0,1,-1,0,0};
    private static int dh[] = {1,-1,0,0,0,0};
    //[ h,y,x,day ]
    private static Queue<int[]> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        
        map = new int [height][row][col];
        visited = new boolean[height][row][col];
        
        for(int i=height-1;i>=0;i--){
            for(int k = 0;k<row;k++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<col;j++){
                    map[i][k][j] = Integer.parseInt(st.nextToken());
                    if(map[i][k][j]==1){
                            cnt++;
                            //[ h,y,x,day ]
                            que.add(new int[]{i,k,j,0});
                            visited[i][k][j] = true;
                        }
                    else if(map[i][k][j]==-1){
                            cnt++;
                            visited[i][k][j] = true;
                        }
                }
            }
        }
        
        if(cnt==height*row*col){
            System.out.println("0");
            System.exit(0);
        }

        int result = bfs();
        System.out.println(result);
        
    }
    
    public static int bfs(){
        
        while(!que.isEmpty()){
            int[] cur = que.poll();//[ h,y,x,day ]
            for(int i=0;i<6;i++){
                int h = dh[i]+cur[0];
                int x = dx[i]+cur[2];
                int y = dy[i]+cur[1];
                if(x>=0&&x<col&&y>=0&&y<row&&h>=0&&h<height){
                    if(!visited[h][y][x]&&map[h][y][x]==0){
                        cnt++;
                        if(cnt==height*row*col){
                            return cur[3]+1;
                        }
                        else{
                            visited[h][y][x]= true;
                            que.add(new int[]{h,y,x,cur[3]+1});
                        }                       
                    }
                }
            }
        }
        
        return -1;
    }
}
