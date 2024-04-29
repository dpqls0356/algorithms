import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ6593 {

    /**
     * 상범이의 이동 : 동서남북상하
     * 출구로만 탈출이 가능하다
     * L = 층수 R=row C=col
     *
     * # 막힌 길
     * . 빈캄
     * S 시작점
     * E 출구
     *
     * 출력
     * Escaped in x minute(s).         x가 결과
     * Trapped!
     * */

    static char arr[][][];
    static boolean visited[][][];
    static int R, C, L;
    static class Spot{
        int x,y,z,time;
        public Spot(){}
        public Spot(int x,int y,int z,int time){
            this.x=x;
            this.y=y;
            this.z=z;
            this.time = time;
        }


    }
    static Spot endSpot;
    static Queue<Spot> que;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L<1||R<1||C<1){
                break;
            }
            else{
                visited = new boolean[R][C][L];
                arr = new char[R][C][L];
                que = new ArrayDeque<>();
                for(int i=0;i<L;i++){
                    for(int k=0;k<R;k++) {
                        String str = br.readLine();
                        for (int j = 0; j < C; j++) {
                            arr[k][j][i] = str.charAt(j);
                            if(arr[k][j][i]=='S'){
                                que.add(new Spot(k,j,i,0));
                                visited[k][j][i] = true;
                            }
                            if(arr[k][j][i]=='#'){
                                visited[k][j][i] = true;
                            }
                            if(arr[k][j][i]=='E'){
                                endSpot = new Spot(k,j,i,0);
                            }
                        }
                    }
                   String str2= br.readLine();
                }
                BFS();
            }
        }
    }

    public static void BFS(){

        while(!que.isEmpty()){

            Spot cur = que.poll();

            if(cur.x==endSpot.x&&cur.y== endSpot.y&&cur.z== endSpot.z){
                System.out.println("Escaped in "+cur.time+" minute(s).");
                return;
            }

            //돌리기
            int dx[] = {0,0,-1,1,0,0};
            int dy[] = {-1,1,0,0,0,0};
            int dz[] = {0,0,0,0,-1,1};

            for(int i=0;i<6;i++){
                int x = cur.x+dx[i];
                int y = cur.y+dy[i];
                int z = cur.z+dz[i];

                if(x>=0&&y>=0&&z>=0&&x<R&&y<C&&z<L&&(arr[x][y][z]=='.'||arr[x][y][z]=='E')&&!visited[x][y][z]){
                    visited[x][y][z] = true;
                    que.add(new Spot(x,y,z,cur.time+1));
                }
            }

        }
        System.out.println("Trapped!");
    }
}
