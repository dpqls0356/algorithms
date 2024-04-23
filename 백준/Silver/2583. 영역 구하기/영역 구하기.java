import java.io.*;
import java.util.*;

public class Main {

    static int arr[][];
    static int N, M;
    static ArrayList<Integer> list = new ArrayList<>();
    static int visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            for (int k = startX; k <endX; k++) {
                for (int j = startY; j < endY; j++)
                    visited[k][j] = 1;
            }

        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (visited[i][k]==0) {

                    list.add(BFS(i, k));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }

    }

    public static int BFS(int i,int k) {

        int size=0;

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {i,k});

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        while(!que.isEmpty()) {
            int cur[] = que.poll();
            for(int a=0;a<4;a++) {
                int x = cur[0]+dx[a];
                int y = cur[1]+dy[a];
                if(x>=0&&y>=0&&x<N&&y<M&&visited[x][y]==0) {
                    size++;
                    que.add(new int[] {x,y});
                    visited[x][y] = 1;
                }
            }
        }
        if(size==0)size=1;
        return size;
    }
}