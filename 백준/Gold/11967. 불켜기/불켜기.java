import java.util.*;
import java.io.*;

public class Main {
    
    private static ArrayList<int[]>[][] arr;
    private static boolean[][] visited;
    private static boolean[][] light;
    private static int N,M;
    private static int cnt;
    private static int[] dy = {1,-1,0,0};
    private static int[] dx = {0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1][N+1];
        light = new boolean[N+1][N+1];
        for(int i=0;i<N+1;i++){
            for(int k=0;k<N+1;k++){
                arr[i][k] = new ArrayList<>();
            }
        }
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[y][x].add(new int[]{a,b});
        }
        
        light[1][1] = true;
        
        boolean change = true;
        
        while(change){
            change = false;
            visited = new boolean[N+1][N+1];
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{1,1});
            visited[1][1] = true;
            
            while(!que.isEmpty()){
                int cur[] = que.poll();
                
                //현재 방에서 킬 수 있는 스위치를 모두 키기
                for(int[] move:arr[cur[0]][cur[1]]){
                    if(!light[move[0]][move[1]]){
                        light[move[0]][move[1]] = true;
                        change = true;
                    }
                }
                
                //이동하기
                for(int i=0;i<dy.length;i++){
                    int y = cur[0]+dy[i];
                    int x = cur[1]+dx[i];
                    if(x>0&&x<=N&&y>0&&y<=N&&!visited[y][x]&&light[y][x]){
                        que.add(new int[]{y,x});
                        visited[y][x] = true;
                    }
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            for(int k=1;k<=N;k++){
                if(light[i][k])cnt++;
            }
        }
        
        System.out.print(cnt);
    }
}
