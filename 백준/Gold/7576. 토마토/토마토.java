import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    static int N,M;
    static int notTomato = 0;
    static Queue<int[]> tomato = new ArrayDeque<>();
    static boolean visited[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k]==1){
                    tomato.add(new int[]{i,k,0});
                    visited[i][k] = true;
                }
                else if(arr[i][k]==0)notTomato++;
            }
        }
        if(notTomato==0){
            System.out.println("0");
            return;
        }
        BFS();
    }
    public static void BFS(){
        while(!tomato.isEmpty()){
            int cur[] = tomato.poll();
            int curX =cur[0];
            int curY = cur[1];

            int dx[] = {0,1,0,-1};
            int dy[] = {1,0,-1,0};

            for(int i=0;i<4;i++){
                int x = curX+dx[i];
                int y = curY+dy[i];
                if(x>=0&&x<N&&y>=0&&y<M&&!visited[x][y]&&arr[x][y]==0){
                    visited[x][y]= true;
                    arr[x][y] = 1;
                    tomato.add(new int[]{x,y,cur[2]+1});
                    notTomato--;
                }
                if(notTomato==0){
                    System.out.println(cur[2]+1);
                    return;
                }
            }

        }
        System.out.println("-1");
    }
}