import java.util.*;
import java.io.*;

public class Main {
	static int M,N,H;
	static int[][][] list;
	static int[] dm = {0,1,0,-1,0,0}; // 좌우
	static int[] dn = {1,0,-1,0,0,0}; // 앞뒤
	static int[] dh = {0,0,0,0,1,-1}; // 위아래
	static Queue<int[]> que = new LinkedList<>(); //queue에는 m,n,h 며칠째에 익었는지 체크
	static boolean visited[][][];
	static int notTomato =0;
	public static void main(String args[])throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로
		H = Integer.parseInt(st.nextToken());	//높이
		
		
		//입력받기
		list = new int[H][M][N];
		visited = new boolean[H][M][N];
		for(int h=H-1;h>=0;h--) {
			for(int n= 0;n<N;n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0;m<M;m++) {
					list[h][m][n] = Integer.parseInt(st.nextToken());
					if(list[h][m][n]==1) {
						que.add(new int[] {h,m,n,0});
						visited[h][m][n]  = true;
					}
					if(list[h][m][n]==0)notTomato++;
				}
			}
		}
		if(notTomato==0)System.out.println(0);
		else BFS();
		
	}
	public static void BFS() {
		while(!que.isEmpty()) {
			int cur[] = que.poll(); //h,m,n,day;
			
			for(int i=0;i<dm.length;i++) {
				int h = cur[0]+dh[i];
				int m = cur[1]+dm[i];
				int n = cur[2]+dn[i];
				//범위안에 있고 -1일때
				if(h>=0&&h<H&&m>=0&&m<M&&n>=0&&n<N&&!visited[h][m][n]&&list[h][m][n]==0) {
					visited[h][m][n]=true;
					list[h][m][n]=1;
					notTomato--;
					que.add(new int[] {h,m,n,cur[3]+1});
				}
			}
			
			if(notTomato==0) {
				System.out.println(cur[3]+1);
				return ;
			}
		}
		System.out.println("-1");
	}
}