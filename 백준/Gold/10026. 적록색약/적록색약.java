
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cntR=0;
	static int cntN=0;
	static boolean visitedR[][];
	static boolean visitedN[][];
	static char arr[][];
	static int x[] = {1,0,-1,0};
	static int y[] = {0,1,0,-1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		visitedR = new boolean[N][N];
		visitedN= new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<N;k++) {
				arr[i][k] = str.charAt(k);
			}
		}
		//일반사람은 3번 DFS
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visitedR[i][k]&&arr[i][k]=='R') {
					visitedR[i][k] = true;
					DFSR('R',i,k);
					cntR++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visitedR[i][k]&&arr[i][k]=='G') {
					visitedR[i][k] = true;
					DFSR('G',i,k);
					cntR++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visitedR[i][k]&&arr[i][k]=='B') {
					visitedR[i][k] = true;
					DFSR('B',i,k);
					cntR++;
				}
			}
		}
//		//색약은 2번만 DFS
//		DFSN('R',0,0);
//		DFSN('B',0,0);
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visitedN[i][k]&&(arr[i][k]=='R'||arr[i][k]=='G')) {
					visitedN[i][k] = true;
//					System.out.println(i+" "+k);
					DFSN('R',i,k);
					cntN++;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visitedN[i][k]&&arr[i][k]=='B') {
					visitedN[i][k] = true;
					DFSN('B',i,k);
					cntN++;
				}
			}
		}
		System.out.print(cntR+" "+cntN);
	}
	public static void DFSR(char c,int row,int col) {
			for(int i=0;i<4;i++) {
				int dx = row + x[i];
				int dy = col+ y[i];
				if(dx>=0&&dx<N&&dy>=0&&dy<N&&arr[dx][dy]==c&&!visitedR[dx][dy]) {
					visitedR[dx][dy] = true;
					DFSR(c,dx,dy);
				}
			}
	}
	public static void DFSN(char c,int row,int col) {
		for(int i=0;i<4;i++) {
			int dx = row + x[i];
			int dy = col+ y[i];
			if(dx>=0&&dx<N&&dy>=0&&dy<N&&!visitedN[dx][dy]) {
				if((c=='R'||c=='G')&&(arr[dx][dy]=='R'||arr[dx][dy]=='G')) {
					visitedN[dx][dy] = true;
					DFSN(c,dx,dy);		
				}
				else if(c=='B'&&arr[dx][dy]=='B'){
					visitedN[dx][dy] = true;
					DFSN(c,dx,dy);	
				}
			}
		}
	}
}
