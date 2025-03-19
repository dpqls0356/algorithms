import java.io.*;
import java.util.*;

class Move{
    int x;
    int y;
    int cnt;
    int useChance;
    int isAfternoon; //1 = 낮 , 0 = 밤
    
    //하 .. 생성자 x,y받는 순서 틀림
    public Move(int y,int x,int cnt,int useChance,int isAfternoon){
        this.x = x ;
        this.y = y ;
        this.cnt = cnt;
        this.useChance = useChance;
        this.isAfternoon = isAfternoon;
    }
}
public class Main {
    public static int[][] map;
    public static int N,M,K;
    public static boolean[][][][] visited;
    public static int[] dy = {1,-1,0,0};
    public static int[] dx = {0,0,1,-1};
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][K+1][2];
        
        for(int i=1;i<=N;i++){
            String str = br.readLine();
            for(int k=1;k<=M;k++){
                map[i][k] = Integer.parseInt(str.charAt(k-1)+"");
            }
        }
        
        int result = bfs();
        
        System.out.print(result);
        
    }
    
    public static int bfs() {
        Deque<Move> que = new ArrayDeque<>();
        que.add(new Move(1, 1, 1, 0, 1)); // (y, x, cnt, 부순횟수, 낮=1)
        visited[1][1][0][1] = true;

        while (!que.isEmpty()) {
            Move cur = que.poll();
            if (cur.x == M && cur.y == N) return cur.cnt;

            int nextDay = cur.isAfternoon == 1 ? 0 : 1;

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int y = cur.y + dy[i];
                int x = cur.x + dx[i];

                if (x <= 0 || x > M || y <= 0 || y > N) continue;

                //벽일 경우
                if(map[y][x] == 1){
                    if(cur.isAfternoon == 1 && cur.useChance < K && !visited[y][x][cur.useChance + 1][nextDay]){
                        visited[y][x][cur.useChance + 1][nextDay] = true;
                        que.add(new Move(y, x, cur.cnt + 1, cur.useChance + 1, nextDay));
                    }
                    else if(cur.isAfternoon == 0 && !visited[cur.y][cur.x][cur.useChance][1]){
                        visited[cur.y][cur.x][cur.useChance][1] = true;
                        que.add(new Move(cur.y, cur.x, cur.cnt + 1, cur.useChance, 1));
                    }
                }
                // 길일 경우
                else if (map[y][x] == 0 && !visited[y][x][cur.useChance][nextDay]) {
                    visited[y][x][cur.useChance][nextDay] = true;
                    que.add(new Move(y, x, cur.cnt + 1, cur.useChance, nextDay));
                }
                

            }


        }
        return -1;
    }

}
