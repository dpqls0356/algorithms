import java.io.*;
import java.util.*;
/*
방문배열을 어떤 형태로 할 것인가.
n * m * k (k=벽을 부순 횟수)
그러면 낮밤은 ? 꼭 분리해야하는가 ? 
분리해서 체킹해야할듯 ? n*m*k*2
왜냐하면 만약 낮에 와서 true처리를 했는데 
머무르기를 할 때 방문 체크를 하면 낮에 이미 true로 해놨기때문에 머무를수가 없음
*/
/*
실수 리스트 
1. 방문여부 체크할때 !visited로 안하고 visited로함
2. Move 생성자에서 x,y로 받아버림 ;;
3. 큐에 삽입 시 방문 처리 안해줌

*/
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
    
public static int bfs(){
    Deque<Move> que = new ArrayDeque<>();
    que.add(new Move(1, 1, 1, 0, 1)); // 낮(1) 시작
    visited[1][1][0][1] = true;

    while(!que.isEmpty()){
        Move cur = que.poll();

        if(cur.x == M && cur.y == N) return cur.cnt;

        int nextDay = cur.isAfternoon == 1 ? 0 : 1;

        // 4방향 탐색
        for(int i = 0; i < 4; i++){
            int ny = cur.y + dy[i];
            int nx = cur.x + dx[i];

            if(ny <= 0 || ny > N || nx <= 0 || nx > M) continue;

            // 벽인 경우
            if(map[ny][nx] == 1) {
                // 낮 + 부술 찬스 남아있으면 부수기
                if(cur.isAfternoon == 1 && cur.useChance < K && !visited[ny][nx][cur.useChance + 1][nextDay]){
                    visited[ny][nx][cur.useChance + 1][nextDay] = true;
                    que.add(new Move(ny, nx, cur.cnt + 1, cur.useChance + 1, nextDay));
                }
            }
            // 길인 경우
            else if(map[ny][nx] == 0 && !visited[ny][nx][cur.useChance][nextDay]){
                visited[ny][nx][cur.useChance][nextDay] = true;
                que.add(new Move(ny, nx, cur.cnt + 1, cur.useChance, nextDay));
            }
        }

        // 밤일 때는 "머무르기"를 무조건 고려
        if(cur.isAfternoon == 0 && !visited[cur.y][cur.x][cur.useChance][nextDay]){
            visited[cur.y][cur.x][cur.useChance][nextDay] = true;
            que.add(new Move(cur.y, cur.x, cur.cnt + 1, cur.useChance, nextDay));
        }
    }
    return -1;
}

}
