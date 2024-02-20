
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[][] ;
	static char arr[][];
	static int x[] = {1,0,-1,0};
	static int y[] = {0,1,0,-1};
	static int N;
	static int red;
	static int blue;
	static int green;
	static int rg;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<N;k++) {
				arr[i][k] = str.charAt(k);
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visited[i][k]) {
					if(arr[i][k]=='R') {
						DFS('R',i,k);
						red++;
					}
					if(arr[i][k]=='G') {
						DFS('G',i,k);
						green++;
					}
					if(arr[i][k]=='B') {
						DFS('B',i,k);
						blue++;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++)visited[i][k]=false;
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visited[i][k]&&(arr[i][k]=='G'||arr[i][k]=='R')) {
					DFS(i,k);
					rg++;
				}
			}
		}
		System.out.println((red+green+blue)+" "+(rg+blue));
	}
	public static void DFS(char color,int row,int col) {
		for(int i=0;i<4;i++) {
			int dx = row + x[i];
			int dy = col+ y[i];
			if(dx>=0&&dx<N&&dy>=0&&dy<N&&arr[dx][dy]==color&&!visited[dx][dy]) {
				visited[dx][dy] = true;
				DFS(color,dx,dy);
			}
		}
	}
	public static void DFS(int row,int col) {
		for(int i=0;i<4;i++) {
			int dx = row + x[i];
			int dy = col+ y[i];
			if(dx>=0&&dx<N&&dy>=0&&dy<N&&(arr[dx][dy]=='R'||arr[dx][dy]=='G')&&!visited[dx][dy]) {
				visited[dx][dy] = true;
				DFS(dx,dy);
			}
		}
	}
}
