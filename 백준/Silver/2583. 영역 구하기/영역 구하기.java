import java.util.*;
import java.io.*;

/*

분리된 공간과 사이즈 체킹
row col k(직사각형 갯수 즉 입력값)
왼쪽 아래 꼭짓점 x(col),y(row) 오른쪽 윗 꼭직점 x(col),y(row)

왼쪽 아래 꼭짓점 0,0 즉 양수만 나옴

사각형 범위를 방문처리해놓고 방문 안한 경우에만 bfs 돌리면 될 듯??

*/
public class Main {
    
    private static boolean[][] visited;
    private static ArrayList<Integer> sizeArray = new ArrayList<>();
    private static int col;
    private static int row;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int inputSize = Integer.parseInt(st.nextToken());
        
        visited = new boolean[row][col];
        
        for(int i=0;i<inputSize;i++){
            st = new StringTokenizer(br.readLine());
            int x1 =  Integer.parseInt(st.nextToken());
            int y1 =  Integer.parseInt(st.nextToken());
            int x2 =  Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());
            for(int k = x1;k<x2;k++){ // for(int k = x1;k<=x2;k++){ 잘못된 범위 씀
                for(int j=row-y2;j<row-y1;j++){
                    visited[j][k] = true; //y,x 반대로 씀
                }
            }
            
        }
        
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(!visited[i][k]){
                    int result = dfs(i,k);
                    sizeArray.add(result);
                }
            }
        }
        
        Collections.sort(sizeArray);
        
        System.out.println(sizeArray.size());
        for(int i=0;i<sizeArray.size();i++){
            System.out.print(sizeArray.get(i)+" ");
        }
        
    }
    
    public static int dfs(int y,int x){
        int size = 1;
        visited[y][x] = true; // 방문체크 안함
        for(int i=0;i<4;i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX>=0&&newX<col&&newY>=0&&newY<row&&!visited[newY][newX]){
                visited[newY][newX] = true;
                size+=dfs(newY,newX);
            }
        }
        return size;
    }
}
