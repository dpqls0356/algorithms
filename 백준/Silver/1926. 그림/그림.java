import java.util.*;
import java.io.*;


public class Main {

    private static boolean[][] visited;
    private static int[][] arrow = {{0,-1},{0,1},{-1,0},{1,0}};
    private static int maxSize= 0;
    private static int count = 0;
    private static int[][] map;
    private static int row;
    private static int col;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        visited = new boolean[row][col];
        
        for(int i=0;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<col;k++){
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(!visited[i][k]&&map[i][k]==1){
                    // System.out.println("start\n"+i+" "+k);
                    count++;
                    maxSize = Math.max(countingPrint(i,k),maxSize);
                }
            }
        }
        System.out.println(count);
        System.out.println(maxSize);
    }
    
    public static int countingPrint(int curX,int curY){
        
        int size = 1;
        
        visited[curX][curY] = true;
        
        for(int i=0;i<4;i++){
            int newX = curX+arrow[i][1];
            int newY = curY+arrow[i][0];
            //x,y가 범위를 넘어서거나 0이거나 이미 방문한 곳이면 접근 불가이기에 zeroCnt 를 늘려주기
            if(newX>=0&&newX<row&&newY>=0&&newY<col&&map[newX][newY]!=0&&!visited[newX][newY]){
                // System.out.println(newX+" "+newY);
                size+=countingPrint(newX,newY);
            }
        }
        return size;
        
    }
}
