import java.util.*;
import java.io.*;

/*
상범이 이동 앞 뒤 양옆 위 아래
빌딩 층수 L 
한층의 R
한층의 C
막힌 칸 #
비어있는칸 . 
시작점 S
도착점 E

음 x,y,z로 쓰는게 맞지않나 .....

*/
public class Main {
    
    private static int L;
    private static int R;
    private static int C;
    private static char[][][] map;
    private static boolean[][][] visited;
    private static Queue<int[]> me;
    private static int[] destination = new int[3];
    private static int[] dh = new int[]{1,-1,0,0,0,0}; 
    private static int[] dy = new int[]{0,0,1,-1,0,0}; 
    // private static int[] dx = new int[]{1,-1,0,0,0,0};  아오 ... 왜 이동을 안하나 했다 ...... 
    private static int[] dx = new int[]{0,0,0,0,1,-1};
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true){
            
            st = new StringTokenizer(br.readLine());
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(L==0&&R==0&&C==0)break;
            
            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            me = new LinkedList<>();
                    
            for(int i=0;i<L;i++){
                for(int k=0;k<R;k++){
                    String str = br.readLine();
                    for(int j=0;j<C;j++){
                        map[i][k][j] = str.charAt(j);
                        if(map[i][k][j]=='S'){
                            me.add(new int[]{i,k,j,0});
                            visited[i][k][j] = true;
                        }
                        else if(map[i][k][j]=='E'){
                            // visited[i][k][j] = true; 바봅 왜 방문처리를 해 !!!!!!! 
                            destination = new int[]{i,k,j};
                        }
                        else if(map[i][k][j]=='#'){
                            visited[i][k][j] = true;
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs();
            if(result == -1){
                    sb.append("Trapped!\n");
                }
            else{
                    sb.append("Escaped in "+result+" minute(s).\n");
                }
        }
        
             System.out.print(sb.toString());
        
    }
    public static int bfs(){
        
        while(!me.isEmpty()){
            int[] cur = me.poll(); //h , y , x , move
            if(cur[0]==destination[0]&&cur[1]==destination[1]&&cur[2]==destination[2]){
                return cur[3];
            }
            // System.out.println(cur[0]+" "+cur[1]+" "+cur[2]+" ");
            for(int i=0;i<6;i++){
                int h = cur[0]+dh[i];
                int y = cur[1]+dy[i];
                int x = cur[2]+dx[i];
                
                if(h>=0&&h<L&&y>=0&&y<R&&x>=0&&x<C&&!visited[h][y][x]){
                    visited[h][y][x] = true;
                    me.add(new int[]{h,y,x,cur[3]+1});
                }
            }
        }
        
        return -1;
    }
}
