import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	//방문배열
	//연결리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][M+1];
		boolean visited[][] = new boolean[N+1][M+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int k=1;k<M+1;k++) {
				arr[i][k] = str.charAt(k-1)-'0';
			}
		}
		Queue<int[]> que = new LinkedList<>();
		int x[] = {1,0,-1,0};
		int y[] = {0,1,0,-1};
		que.add(new int[] {1,1});
		visited[1][1]= true;
		
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for(int i=0;i<4;i++) {
				//이동위치 찍기
				int dx = cur[0]+x[i];
				int dy = cur[1]+y[i];
				if(dx>=0&&dx<N+1&&dy>=0&&dy<M+1&&!visited[dx][dy]&&arr[dx][dy]!=0) {
//					System.out.println(arr[dx][dy]+" "+arr[cur[0]][cur[1]]);
					arr[dx][dy]+=arr[cur[0]][cur[1]];
					visited[dx][dy] = true;
					que.add(new int[] {dx,dy});
					if(dx==N&&dy==M)break;
				}
			}
		}
		System.out.println(arr[N][M]);
	}
}
