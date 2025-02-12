import java.util.*;
import java.io.*;
/*
탈출여부 + 빨리 탈출 할 수 있는가
1. 지훈이는 매 분마다 한칸씩!!!! 이동한다
2. 불은 현재 위치에서 사방향으로 이동한다
3. 탈출은 가장자리에 접한 공간에서 탈출 할 수 있다.
*/
public class Main {
    
    private static int row;
    private static int col;
    private static char[][] map; //지도
    private static boolean[][] visited; //벽, 불, 이미 이동한 위치 체킹
    private static Queue<int[]> jihun = new LinkedList<>(); // x,y,cnt
    private static Queue<int[]> fire = new LinkedList<>(); // x,y,cnt
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new char[row][col];
        visited = new boolean[row][col];
        
        for(int i=0;i<row;i++){
            String str =  br.readLine();
            for(int k=0;k<col;k++){
                char c = str.charAt(k);
                map[i][k] = c;
                if(c=='#'){
                    visited[i][k] = true;
                }
                else if(c=='J'){
                    visited[i][k] = true;
                    jihun.add(new int[]{i,k,0});//행/열
                }
                else if(c=='F'){
                    visited[i][k] = true;
                    fire.add(new int[]{i,k,0});
                }
            }
        }
        int result = BFS();
        if(result == -1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(result);
        }
    }
    
    public static int BFS(){
        
        while(!jihun.isEmpty()){
            // System.out.println("=========================");
            // for(int i=0;i<row;i++){
                // for(int k=0;k<col;k++){
                    // System.out.print(map[i][k]+" ");
                // }
                // System.out.println();
            // }
            int cur[] = jihun.poll(); //행,렬,cnt;
            //탈출 위치인 경우 cnt를 리턴
            if(cur[0]==row-1||cur[0]==0||cur[1]==col-1||cur[1]==0){
                return cur[2]+1;
            }
            else{

                map[cur[0]][cur[1]] = '.';
                // System.out.println("============이동전=============");
                // for(int i=0;i<row;i++){
                    // for(int k=0;k<col;k++){
                        // System.out.print(map[i][k]+" ");
                    // }
                    // System.out.println();
                // }
                //불붙이기
                // System.out.println("burning");
                burning(cur[2]);
                // System.out.println("============불 이동 후=============");
                // for(int i=0;i<row;i++){
                    // for(int k=0;k<col;k++){
                        // System.out.print(map[i][k]+" ");
                    // }
                    // System.out.println();
                // }
                //불 옮긴 후 지훈이 이동
                for(int i=0;i<4;i++){
                    int newX = cur[1]+dx[i];//좌우 - 열
                    int newY = cur[0]+dy[i];//상하 - 행
                    if(newX>=0&&newX<col&&newY>=0&&newY<row&&!visited[newY][newX]&&map[newY][newX]=='.'){
                        visited[newY][newX] = true;
                        map[newY][newX] = 'J';
                        jihun.add(new int[]{newY,newX,cur[2]+1});
                    }
                }
            }

        }
        return -1;
    }
    
    public static void burning(int curCnt){
        while(!fire.isEmpty()){
            int cur[] = fire.poll(); // 행 열 cnt
            // System.out.println("cur: "+cur[2]+" "+"curCnt: "+curCnt);
            if(cur[2]!=curCnt){
                fire.add(cur);
                break;
            }
            for(int i=0;i<4;i++){
                int newX = cur[1]+dx[i];// 열
                int newY = cur[0]+dy[i];//행
                if(newX>=0&&newX<col&&newY>=0&&newY<row&&map[newY][newX]=='.'){
                    // System.out.println(newY+" "+newX+" "+cur[2]);
                    map[newY][newX]='F';
                    visited[newY][newX]=true;
                    fire.add(new int[]{newY,newX,cur[2]+1});
                }
            }
        }
        
    }
}
