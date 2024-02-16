import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder  sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			//입력이 0 0이면 멈추기
			if(w==0&&h==0)break;
			//섬과 바다를 담을 배열 만들기
			int arr[][] = new int[h+1][w+1];
			// 데이터 넣기 1,1 ~ h,w까지 존재
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<w;k++) {
					arr[i+1][k+1]=Integer.parseInt(st.nextToken());
				}
			}
			//모든 배열을 돌면서 섬일 경우에 landCnt 증가시키기
			// bfs를 돌기위한 조건 현재위치가 0이 아닐때
			boolean visited[][] = new boolean[h+1][w+1];
			int landCnt = 0;
			for(int i=1;i<h+1;i++) {
				for(int k = 1; k<w+1;k++ ) {
					if(!visited[i][k]&&arr[i][k]!=0) {
				        int x[] = {-1,-1,-1,0,0,+1,+1,+1};
				        int y[] = {-1,0,+1,-1,+1,-1,0,+1};
						 Queue<int[]> que = new LinkedList<>();
						 que.add(new int[] {i,k});
						 visited[i][k]=true;
						  while(!que.isEmpty()) {
			                    int cur[] = que.poll();
			                    for(int a=0;a<x.length;a++) {
			                        // 나아갈 수 있을 경우
			                        int dx = cur[0]+x[a];
			                        int dy = cur[1]+y[a];
			                        if(dx>0&&dx<=h&&dy>0&&dy<=w&&!visited[dx][dy]&&arr[dx][dy]!=0) {
//			                            System.out.println(dx+" "+dy);
			                            visited[dx][dy] = true;
			                            que.add(new int[] {dx,dy});
			                        }
			                    }
			            }
						  landCnt++;
					}
				}
			}
			sb.append(landCnt+"\n");
		}
		System.out.print(sb);
	}
}
