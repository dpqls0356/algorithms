import java.util.*;
import java.io.*;

public class Main {
    
    private static int[][] apt;
    private static int N;
    private static boolean[][] visited;
    private static List<Integer> sizes = new ArrayList<>();
    private static int count = 0;
    //상하좌우
    private static int[] dx = new int[]{0,0,-1,1};
    private static int[] dy = new int[]{1,-1,0,0};
    private static Queue<int[]> que = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1][N+1];
        apt = new int[N+1][N+1];
        
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int k=0;k<N;k++){
                apt[i][k] = Integer.parseInt(str.charAt(k)+"");
            }
        }
        for(int i=0;i<N;i++){
            for(int k=0;k<N;k++){
                if(!visited[i][k]&&apt[i][k]==1){
                    count++;
                    bfs(i,k);
                }
            }
        }
        
        Collections.sort(sizes);
        
        System.out.println(count);
        for(int i=0;i<sizes.size();i++){
            System.out.println(sizes.get(i));
        }
        
    }
    
    public static void bfs(int x,int y){
        visited[x][y] = true;
        que.add(new int[]{x,y});
        int size=1;
        
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i=0;i<4;i++){
                int newX = curX+dx[i];
                int newY = curY+dy[i];
                if(newX>=0&&newX<N&&newY>=0&&newY<N&&!visited[newX][newY]&&apt[newX][newY]==1){
                    size++;
                     visited[newX][newY] = true;
                    que.add(new int[]{newX,newY});
                }
            }
        }
        sizes.add(size);
        
    }
}
