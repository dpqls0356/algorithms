import java.util.*;
import java.io.*;

public class Main {
	static boolean visited[];
	static int height, start, end, up, down;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());

		visited = new boolean[height + 1];
		if(down==1&&up==1&&start<end) {
			System.out.println(end-start);
			return;
		}
		if(down==1&&up==1&&end<start) {
			System.out.println(start-end);
			return;
		}
//		DFS(start, 0);
		BFS();
		if (min == Integer.MAX_VALUE)
			System.out.println("use the stairs");
		else
			System.out.println(min);

	}

//	public static void DFS(int cur, int cnt) {
////		System.out.println("cur "+cur);
//		if(cnt>min)return;
//		if (cur == end) { // 도착지에 갔다면
//			if (min > cnt) // 최솟값이 현재 이동횟수보다 클 경우 최솟값 수정
//				min = cnt;
//		} else { // 도착지에 못 갔다면
//			if (up!=0&&cur + up <= height && !visited[cur + up]) { // 아직 방문하지않았고 , 이동했을때 위치가 건물 안일 경우
//				visited[cur + up] = true;
//				DFS(cur + up, cnt + 1);
//				visited[cur + up] = false;
//			}
//			if (down!=0&&cur - down > 0 && !visited[cur - down]) { // 아직 방문하지않았고 , 이동했을때 위치가 건물 안일 경우
//				visited[cur - down] = true;
//				DFS(cur - down, cnt + 1);
//				visited[cur - down] = false;
//			}
//		}
//	}

	public static void BFS() {
		Queue<int[]> que = new ArrayDeque<>();
		que.add(new int[] { start, 0 });
		visited[start] = true;

		while (!que.isEmpty()) {
			int cur[] = que.poll();
			int curPosition = cur[0];	//현재 위치
			int curCnt = cur[1];		//현재까지 이동횟수

			if(curCnt>min)continue;		//현재까지 이동한 횟수가 최소 이동횟수보다 많으면 멈추기
		
			if (curPosition == end) {
				visited[curPosition] =false;
				if(curCnt < min)	//목적지에 도달한 경우
					min = curCnt;				
			}

			else {
				if (up!=0&&curPosition + up <= height&&!visited[curPosition+up]) {
					que.add(new int[] {curPosition+up,curCnt+1});
					visited[curPosition+up] = true;
				}
				if (down!=0&&curPosition - down > 0 &&!visited[curPosition-down]) {
					que.add(new int[] {curPosition-down,curCnt+1});
					visited[curPosition-down] = true;
				}				
			}
		}
	}

}