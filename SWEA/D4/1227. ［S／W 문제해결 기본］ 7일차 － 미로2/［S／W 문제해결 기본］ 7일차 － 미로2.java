
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=1;i<11;i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			//방문배열 생성
			boolean visited[][] = new boolean[100][100];
			// 시작점 , 끝점
			int start[] = new int[2];
			int end[] = new int[2];
			// 미로배열만들기
			int arr[][] = new int[100][100];
			for(int k=0;k<100;k++) {
				String str = br.readLine();
				for(int j=0;j<100;j++) {
					arr[k][j] = str.charAt(j)-'0';
					if(arr[k][j]==2) {
						start[0]=k;
						start[1]=j;
					}
					if(arr[k][j]==3) {
						end[0]=k;
						end[1]=j;
					}
				}
			}
//			System.out.println(start[0]+" "+start[1]);
//			System.out.println(end[0]+" "+end[1]);
			// 이제 미로찾기해오 ............
			Queue<int[]> que = new LinkedList<>();
			visited[start[0]][start[1]] = true;
			que.add(start);
			int x[] = {1,0,-1,0};
			int y[] = {0,1,0,-1};
			boolean ch = false;
			while(!que.isEmpty()) {
				int cur[] = que.poll();
				if(arr[cur[0]][cur[1]]==3) {
					ch = true;
				}
				for(int k=0;k<x.length;k++) {
					int dx = cur[0]+x[k];
					int dy = cur[1]+y[k];
					if(dx>=0&&dx<100&&dy>=0&&dy<100&&!visited[dx][dy]&&(arr[dx][dy]==0||arr[dx][dy]==3)) {
						visited[dx][dy]=true;
						que.add(new int[] {dx,dy});
					}
				}
			}
			if(ch)System.out.println("#"+i+" "+1);
			else System.out.println("#"+i+" "+0);
		}
	}
}
