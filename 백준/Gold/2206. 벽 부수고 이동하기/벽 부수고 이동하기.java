import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Spot{
		int x,y,cnt,chance=1;
		Spot(){}
		Spot(int x,int y, int cnt){
			this.x = x;
			this.y =y;
			this.cnt = cnt;
		}
		Spot(int x,int y, int cnt,int chance){
			this.x = x;
			this.y =y;
			this.cnt = cnt;
			this.chance = chance;
		}
	}
	static int min = Integer.MAX_VALUE;
	static int N,M;
	static int arr[][];
	static boolean visited[][][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		//남은 찬스 수가 1이면서 그 자리에 도착했는지 안했는지 // 남은 찬스 수가 0이면서 그 자리에 도착했는지 안했는지  
		visited = new boolean[2][N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<M;k++) {
				arr[i][k] = str.charAt(k)-'0';
			}
		}
		BFS();
		if(min==Integer.MAX_VALUE)System.out.println("-1");
		else System.out.println(min);
		
		
	}
	
	public static void BFS() {
		Queue<Spot> que = new ArrayDeque<>();
		que.add(new Spot(0,0,1));
		visited[1][0][0] = true;
		
		while(!que.isEmpty()) {
			Spot cur = que.poll();
			if(cur.x==N-1&&cur.y==M-1) {
				if(min>cur.cnt)min = cur.cnt;
				continue;
			}
			int dx[] = {0,1,0,-1};
			int dy[] = {1,0,-1,0};
			for(int i=0;i<4;i++) {
				int x = cur.x+dx[i];
				int y = cur.y+dy[i];
				if(x>=0&&x<N&&y>=0&&y<M) {
//					뛰어넘기
					if(arr[x][y]==1&&cur.chance!=0&&!visited[0][x][y]) {
						que.add(new Spot(x,y,cur.cnt+1,cur.chance-1));
						visited[0][x][y]=true;
						if(x==N-1&&y==M-1) {
							visited[0][x][y]=false;
						}
					}
					else {
						if(arr[x][y]==0) {
							if(!visited[1][x][y]&&cur.chance==1) {
								que.add(new Spot(x,y,cur.cnt+1,cur.chance));
								visited[1][x][y]=true;
								if(x==N-1&&y==M-1) {
									visited[1][x][y]=false;
								}								
							}
							else if(!visited[0][x][y]&&cur.chance==0) {
								que.add(new Spot(x,y,cur.cnt+1,cur.chance));
								visited[0][x][y]=true;
								if(x==N-1&&y==M-1) {
									visited[0][x][y]=false;
								}
							}
						}
					}
				}
			}
			
		}
	}
}