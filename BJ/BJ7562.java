import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7562 {
    static int dx[] = {-1,-1,-2,-2,1,1,2,2};
    static int dy[] = {-2,2,-1,1,-2,2,-1,1};
    static boolean visited[][];
    static int N;
    static int startX,startY;
    static int endX,endY;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int i=0;i<T;i++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            if(startY==endY&&startX==endX){
                System.out.println("0");
                continue;
            }

            BFS();

        }
    }

    public static void BFS(){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {startX,startY,0});
        visited[startX][startY] = true;
        while(!que.isEmpty()){
            int cur[] = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            if(curX==endX&&curY==endY){
                System.out.println(cur[2]);
                return;
            }

            for(int i=0;i<8;i++){
                int x = curX+dx[i];
                int y = curY+dy[i];
                if(x>=0&&x<N&&y>=0&&y<N&&!visited[x][y]){
                    visited[x][y] = true;
                    que.add(new int[] { x,y,cur[2]+1});
                    if(x==endX&&y==endY)visited[x][y]= false;
                }
            }
        }
    }
}
