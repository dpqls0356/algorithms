import java.util.*;
import java.io.*;

public class Main {

	static int arr[][]; // 지도
	static int N; // 지도크기
	static int max = Integer.MIN_VALUE; // 가장 많은 안전영역 수
	static int maxHeight = Integer.MIN_VALUE; // 물이 찰 수 있는 최대 높이
	static int count; // 안전영역 수
	static int water; // 물의 높이
	static boolean visited[][]; // 방문배열
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 지도 크기 받기

		arr = new int[N][N];

		for (int i = 0; i < N; i++) { // 지도에 데이터 넣기
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < N; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
				if (maxHeight < arr[i][k])
					maxHeight = arr[i][k];
			}
		}

		for (int i = 0; i < maxHeight; i++) {
			water = i; // 믈높이
			count = 0; // 안전영역 수
			visited = new boolean[N][N]; // 방문배열
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (!visited[n][m] && arr[n][m] > water) {
						BFS(n, m);
						count++;
					}
				}
			}
			if (count > max)
				max=count;
		}
		if(max==Integer.MIN_VALUE)System.out.println("0");
		else	System.out.println(max);
	}

	public static void BFS(int n, int m) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] { n, m });
		while (!que.isEmpty()) {
			int cur[] = que.poll();
			for (int i = 0; i < 4; i++) {
				int x = cur[0] + dx[i];
				int y = cur[1] + dy[i];
				if(x<N&&x>=0&&y<N&&y>=0&&!visited[x][y]&&arr[x][y]>water) {
					visited[x][y] = true;
					que.add(new int[] {x,y});
				}
			}
		}

	}
}