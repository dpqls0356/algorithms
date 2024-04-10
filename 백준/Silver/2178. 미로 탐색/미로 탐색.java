import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int arr[][];
	static boolean visited[][];
	static class Spot{
		int x;
		int y;
		int cnt;
		public Spot() {}
		public Spot(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt =cnt;
		}
	}
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 arr = new int[N+1][M+1];
		 visited = new boolean[N+1][M+1];
		 for(int i=1;i<N+1;i++) {
			 String str =br.readLine();  
			 for(int k=1;k<M+1;k++) {
				 arr[i][k] = str.charAt(k-1)-'0';

			 }
		 }
		 BFS();
	}
	public static void BFS() {
		Queue<Spot> que = new ArrayDeque();
		que.add(new Spot(1,1,1));
		while(!que.isEmpty()) {
			Spot cur = que.poll();
			if(cur.x==N&&cur.y==M) {
				System.out.println(cur.cnt);
			}
			int dx[] = {1,-1,0,0};
			int dy[] = {0,0,1,-1};
			for(int i=0;i<4;i++) {
				int x = cur.x+dx[i];
				int y = cur.y+dy[i];
				if(x>0&&x<N+1&&y>0&&y<M+1&&!visited[x][y]&&arr[x][y]==1) {
					visited[x][y] = true;
					que.add(new Spot(x,y,cur.cnt+1));
				}
			}
		}
	}
}