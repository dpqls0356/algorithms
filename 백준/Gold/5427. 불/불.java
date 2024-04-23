import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 불 동서남북이동 벽 통과 불가
 * 
 * 상근 동서남북 벽 통과 불가 불이 옮겨진 칸 or 불이 옮겨질 예정인 곳으로 이동 불가 상근이가 있는 칸에 불이 옮겨옴 동시에 다른 칸으로
 * 이동할 수 있다. => 불을 옮기고 상근이 옮기기...
 * 
 * 
 * 입력값 t 1~100 w,h 1~100
 * 
 */
public class Main {

	static char arr[][];
	static int N, M;
	static boolean visited[][];
	//상근이 이동을 담을 큐
	static Queue<Spot> que;
	//불 이동을 담을 큐
	static Queue<Spot> fire;
	static int fireCnt;

	static class Spot {
		int x;
		int y;
		int cnt;	//이동횟수

		public Spot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			arr = new char[N][M];
			visited = new boolean[N][M];

			que = new ArrayDeque<>();
			fire = new ArrayDeque<>();
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int k = 0; k < M; k++) {
					arr[i][k] = str.charAt(k);
					if (arr[i][k] == '@') {
						que.add(new Spot(i, k, 0));
						visited[i][k] = true;
					}
					if (arr[i][k] == '*') {
						fire.add(new Spot(i, k, 0));
					}
				}
			}

			BFS();
		}
	}

	public static void BFS() {
		while (!que.isEmpty()) {

			int dx[] = { 0, 1, 0, -1 };
			int dy[] = { 1, 0, -1, 0 };
			
			
			if (!fire.isEmpty() && fire.peek().cnt <= que.peek().cnt) {
				// 불 옮기기
				fireCnt = fire.size();
				for (int i = 0; i < fireCnt; i++) {
					Spot fireSpot = fire.poll();
					for (int k = 0; k < 4; k++) {
						int x = fireSpot.x + dx[k];
						int y = fireSpot.y + dy[k];
						// 불이 퍼질 수 있는 곳 * #이 아니면
						if (x >= 0 && x < N && y >= 0 && y < M) {
							if (arr[x][y] == '.' || arr[x][y] == '@') {
								arr[x][y] = '*';
								fire.add(new Spot(x, y, fireSpot.cnt + 1));

							}
						}
					}
				}

			}
			
			Spot cur = que.poll();
			if (cur.x == 0 || cur.x == N - 1 || cur.y == 0 || cur.y == M - 1) {
				System.out.println(cur.cnt + 1);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && arr[x][y] == '.') {
					visited[x][y] = true;
					que.add(new Spot(x, y, cur.cnt + 1));
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}