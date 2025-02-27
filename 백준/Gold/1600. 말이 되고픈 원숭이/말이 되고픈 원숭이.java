import java.util.*;
import java.io.*;

/*
체스 나이트와 같은 방식으로 이동 
단 이것은 k번만 가능하고
원래는 상하좌우만 가능
맨왼쪽위에서 맨왼쪽 아래쪽까지 이동 -> 0,0, -> row-1,col-1

궁금한점 말은 장애물을 뛰어넘을 수 있다는 건 막힌 공간도 뛰어넘어서 목표지까지 갈 수 있다는거겠죠 ??
그럼 말의 움직임으로 움직이는 원숭이도 장애물을 뛰어넘을 수  있다는 건강

k 
col , row
0 = 평지 1 = 장애물        

일단 방문배열이 k만큼 필요할듯
이것도 벽 부수고 이동하기랑 같은 느낌의 문제로 인 것 같다



*/
public class Main {
    
    private static int K;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int row,col;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    private static int[] horseY = {1,2,2,1,-1,-2,-2,-1};
    private static int[] horseX = {-2,-1,1,2,-2,-1,1,2};
    
    public static void main(String[] args) throws IOException  {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        K = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        
        visited  = new boolean [row][col][K+1]; // 앟 K+1인데 K로 함 ㅜㅜ
        map = new int[row][col];
        
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(st.nextToken());
                // if(map[i][k]==1)visited[i][k][] = false; // 이거 불가능한게 모든 visited[i][k][0 ~ K-1]까지 true해줘야함 ;;; ㅋㅋㅠㅠ 
            }
        }
        
        int result = bfs();
        
        System.out.print(result);
    
    }
    
    public static int bfs(){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,0,0}); // 현재 y,x,move,말처럼 움직인 횟수
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0]==row-1&&cur[1]==col-1){
                return cur[2];
            }
            //말로 움직일 수 있을 때
            if(cur[3]<K){
                for(int i=0;i<horseX.length;i++){
                    int y= cur[0]+horseY[i];
                    int x= cur[1]+horseX[i];
                    if(y>=0&&y<row&&x>=0&&x<col&&!visited[y][x][cur[3]+1]&&map[y][x]==0){
                        visited[y][x][cur[3]+1] = true;
                        que.add(new int[]{y,x,cur[2]+1,cur[3]+1});
                    }
                }
            }
            for(int i=0;i<dx.length;i++){
                int y= cur[0]+dy[i];
                int x= cur[1]+dx[i];
                if(y>=0&&y<row&&x>=0&&x<col&&!visited[y][x][cur[3]]&&map[y][x]==0){
                    visited[y][x][cur[3]] = true;
                    que.add(new int[]{y,x,cur[2]+1,cur[3]});
                }
            }
            
        }
              
        return -1;
    }
}
