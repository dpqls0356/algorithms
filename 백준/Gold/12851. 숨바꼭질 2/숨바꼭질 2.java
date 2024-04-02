import java.util.*;
import java.io.*;

public class Main {

	public static boolean visited[] = new boolean[100001]; // 방문배열
	public static int start, end; // 시작점과 도착점
	public static int minTime = Integer.MAX_VALUE; // 최소이동시간
	public static int count = 0; // 최소이동시간으로 이동한 횟수

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		if (start >= end) {
			System.out.println(start-end);
			System.out.println(1);
			return;
		}
		visited[start] = true;

		BFS();

		System.out.println(minTime);
		System.out.println(count);
	}

	public static void BFS() {

		Queue<int[]> que = new ArrayDeque();
		que.add(new int[] { start, 0 }); // 시작점 넣기
		while (!que.isEmpty()) {
			int cur[] = que.poll();
			int curSpot = cur[0];
			int movingTime = cur[1];

			visited[curSpot] = true;
			if (curSpot == end && minTime >= movingTime) {
				minTime = movingTime;
				count++;
			}
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					int movingSpot = curSpot - 1;
					if (movingSpot >= 0 && !visited[movingSpot]) {
						que.add(new int[] { movingSpot, movingTime + 1 });
						if (movingSpot == end) {
							visited[movingSpot] = false;
						}
					}
				} else if (i == 1) {
					int movingSpot = curSpot + 1;
					if (movingSpot <= 100000 && !visited[movingSpot]) {
						que.add(new int[] { movingSpot, movingTime + 1 });
						if (movingSpot == end) {
							visited[movingSpot] = false;
						}
					}
				} else if (i == 2) {
					int movingSpot = curSpot * 2;
					if (movingSpot <= 100000 && !visited[movingSpot]) {
						que.add(new int[] { movingSpot, movingTime + 1 });
						if (movingSpot == end) {
							visited[movingSpot] = false;
						}
					}
				}
			}

		}

	}
}