import java.util.*;
import java.io.*;

public class Main {
	
	static int arr[][];	//지도
	static int dx[] = {1,0,-1,0};	//네방향
	static int dy[] = {0,1,0,-1};	
	static int N,M;	//배열의 크기
	static int time = 0;	//걸린시간
	static int cnt = 0;		// 안녹은 빙하 수 
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<M;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				cnt++;
			}
		}

		while(cnt!=0) {
			//현재 상태에서 얼만큼 녹일지 확인
			int minus[][] = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int k=0;k<M;k++) {
					if(arr[i][k]!=0) {	// 빙하이면서
						for(int a=0;a<4;a++) {
							int x = i+dx[a];
							int y = k+dy[a];
							if(x>=0&&x<N&&y>=0&&y<M&&arr[x][y]==0) { //범위내의 장소이면서 바닷물일 경우
								minus[i][k]++; //빙하의 감소값 증가시키기
							}
						}
					}
				}
			}
			//녹이기
			for(int i=0;i<N;i++) {
				for(int k=0;k<M;k++) {
					if(minus[i][k]!=0) {	//빙하라면
						arr[i][k]-=minus[i][k];	// 감소시킬 값만큼 빙하 줄이기
						if(arr[i][k]<=0) {	//0보다 작아지면 0을 넣고 안녹은 빙하의 수 줄이기
							arr[i][k]=0;
							cnt--;
						}
					}
				}
			}
			time++; //시간증가
			//빙산이 분리되었는지 확인 -> 섬의 개수 ?
			visited = new boolean[N][M];
			int part = 0;
			for(int i =0;i<N;i++) {
				for(int k=0;k<M;k++) {
					if(!visited[i][k]&&arr[i][k]!=0) {//방문안했고 빙하인 경우에만 BFS
						BFS(i,k);
						part++;	// 빙하 한 덩어리 탐색 했으니 덩어리 수 +1
					}
				}
			}
			// -----분리되었으면 = 덩어리가 한 개가 아니라면
			if(part==0) {break;}
			if(part!=1) { 
				System.out.println(time);
				return ;
			}
		}
		System.out.println("0");
	}
	public static void BFS(int startX,int startY) {
		Queue <int []> que = new ArrayDeque<>();
		que.add(new int[] {startX,startY});
		visited[startX][startY] = true;
		
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for(int i=0;i<4;i++) {
				int x =cur[0]+dx[i];
				int y = cur[1]+dy[i];
				if(x>=0&&x<N&&y>=0&&y<M&&!visited[x][y]&&arr[x][y]!=0) {
					visited[x][y] = true;
					que.add(new int[] {x,y});
				}
			}
		}
	}
}


//			System.out.println(part);
//			for(int i=0;i<N;i++) {
//				for(int k=0;k<M;k++) {
//					System.out.print(arr[i][k]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("------------");