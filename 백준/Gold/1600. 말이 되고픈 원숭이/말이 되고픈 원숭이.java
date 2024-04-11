import java.util.*;
import java.io.*;

public class Main {
	
	static class Spot{//원숭이 위치
		int x,y,cnt;
		int horse;//말처럼 갈 수 있는 횟수
		public Spot() {}
		public Spot(int x,int y,int cnt,int horse) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.horse = horse;
		}
	}
	static int arr[][];
	static boolean visited[][][];
	static int N,M;
	static int horseCnt;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		horseCnt = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		visited  = new boolean[horseCnt+1][N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1;k<=M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
		if(min==Integer.MAX_VALUE)System.out.println("-1");
		else System.out.println(min);
	}
	
	public static void BFS() {
		Queue<Spot> que = new ArrayDeque<>();
		que.add(new Spot(1,1,0,horseCnt));
		visited[horseCnt][1][1] = true;
		while(!que.isEmpty()) {
			Spot cur = que.poll();
//			System.out.println("cur x,y: "+cur.x+" "+cur.y+" horse"+cur.horse);
			if(cur.x==N&&cur.y==M) {
				if(min>cur.cnt)min = cur.cnt;
				continue;
			}
			if(cur.cnt>min)continue;
			//말의 이동
			if(cur.horse>0) {
				//row-1 col-2
				int x = cur.x-1;
				int y = cur.y-2;
				if(x>0&&y>0&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row-1 col+2
				x = cur.x-1;
				y = cur.y+2;
				if(x>0&&y<=M&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row-2 col-1
				x = cur.x-2;
				y = cur.y-1;
				if(x>0&&y>0&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row-2 col+1
				x = cur.x-2;
				y = cur.y+1;
				if(x>0&&y<=M&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row+1 col-2
				x = cur.x+1;
				y = cur.y-2;
				if(x<=N&&y>0&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row+1 col+2
				x = cur.x+1;
				y = cur.y+2;
				if(x<=N&&y<=M&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row+2 col-1
				x = cur.x+2;
				y = cur.y-1;
				if(x<=N&&y>0&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
				//row+2 col+1
				x = cur.x+2;
				y = cur.y+1;
				if(x<=N&&y<=M&&!visited[cur.horse-1][x][y]&&arr[x][y]==0) {
					visited[cur.horse-1][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse-1));
					if(x==cur.x&&cur.y==y)visited[cur.horse-1][x][y]=false;
					//System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse-1));
				}
			}
			//4방향 이동
			int dx[] = {1,0,-1,0};
			int dy[] = {0,1,0,-1};
			for(int i=0;i<4;i++) {
				int x = cur.x+dx[i];
				int y = cur.y+dy[i];
				if(x>0&&x<=N&&y>0&&y<=M&&!visited[cur.horse][x][y]&&arr[x][y]==0) {
					visited[cur.horse][x][y]=true;
					que.add(new Spot(x,y,cur.cnt+1,cur.horse));
					if(x==cur.x&&cur.y==y)visited[cur.horse][x][y]=false;
//					System.out.println("x,y: "+x+" "+y+" horse:"+(cur.horse));
				}
			}
//			System.out.println("====================");
		}
	}
}