import java.util.*;
import java.io.*;

public class Main {

	static class Move {
		int x, y; // 청소기 위치
		int direction; // 진행방향

		public Move() { // 기본 생성자
		}

		public Move(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	static int map[][]; // 지도
	static int N, M; // 지도 크기
	static int clean = 0; // 청소횟수
	static boolean visited[][]; // 청소를 이미 한 곳인지 기록

	public static void main(String[] args) throws IOException {

		// 지도 크기받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 배열 생성
		map = new int[N][M];
		visited = new boolean[N][M];

		// 현재 청소기 위치, 방향 받기
		st = new StringTokenizer(br.readLine());
		Move move = new Move();
		move.x = Integer.parseInt(st.nextToken());
		move.y = Integer.parseInt(st.nextToken());
		move.direction = Integer.parseInt(st.nextToken());

		// 지도 상태 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				map[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기위치 큐에 담기
		Queue<Move> que = new ArrayDeque();
		que.add(move);

		while (!que.isEmpty()) {
			// 현재 청소할 위치 가져오기
			Move cur = que.poll();
//			System.out.println("cur " + cur.x + " " + cur.y);
			// 청소가 안되어있는 경우에만
			if (!visited[cur.x][cur.y])
				clean++;
			// 청소하기
			visited[cur.x][cur.y] = true;
//			map[cur.x][cur.y] = 2;
//			for (int i = 0; i < N; i++) {
//				for (int k = 0; k < M; k++) {
//					System.out.print(map[i][k] + " ");
//				}
//				System.out.println();
//			}
			boolean isClean = true; // 4방향 모두 청소를 다 했는지 판단
			// 4방향 돌면서 청소안한곳있는지 찾기
			for (int i = 1; i < 5; i++) {
				int turn = cur.direction-i; // 90도로 회전
				if(turn<0) {
					turn = 4-i+cur.direction;
				}
				// 동
				if (turn == 1) {
					int x = cur.x;
					int y = cur.y + 1;
					if (y + 1 < M && !visited[x][y] && map[x][y] != 1) {
						que.add(new Move(x, y, 1));
						isClean = false;
						break;
					}
				}
				// 남
				else if (turn == 2) {
					int x = cur.x + 1;
					int y = cur.y;
					if (x + 1 < N && !visited[x][y] && map[x][y] != 1) {
						que.add(new Move(x, y, 2));
						isClean = false;
						break;
					}
				}
				// 서
				else if (turn == 3) {
					int x = cur.x;
					int y = cur.y - 1;
					if (y >= 0 && !visited[x][y] && map[x][y] != 1) {
						que.add(new Move(x, y, 3));
						isClean = false;
						break;
					}
				}
				// 북
				else if (turn == 0) {
					int x = cur.x - 1;
					int y = cur.y;
					if (x >= 0 && !visited[x][y] && map[x][y] != 1) {
						que.add(new Move(x, y, 0));
						isClean = false;
						break;
					}
				}
			}
			if (isClean) {
				switch (cur.direction) {
				// 북쪽으로 바라볼 경우 남쪽으로로 이동
				case 0: {
					if (cur.x + 1 < N && map[cur.x + 1][cur.y] == 1) {
						System.out.println(clean);
						return;
					} else {
//						System.out.println("북"+(cur.x + 1) + " " + cur.y);
						que.add(new Move(cur.x + 1, cur.y, 0));
					}
					break;
				}
				// 동쪽으로 바라볼 경우 서쪽으로 이동
				case 1: {
					if (cur.y - 1 >= 0 && map[cur.x][cur.y - 1] == 1) {
						System.out.println(clean);
						return;
					} else {
						que.add(new Move(cur.x, cur.y - 1, 1));
//						System.out.println("동"+(cur.x) + " " + (cur.y - 1));
					}
					break;
				}
				// 남쪽을 바라볼 경우 북쪽으로 이동
				case 2: {
					if (cur.x - 1 >= 0 && map[cur.x - 1][cur.y] == 1) {
						System.out.println(clean);
						return;
					} else {
						que.add(new Move(cur.x - 1, cur.y, 2));
//						System.out.println("남"+(cur.x - 1) + " " + (cur.y));
					}
					break;
				}
				// 서쪽을 바라볼 경우 동쪽으로 이동
				case 3: {
					if (cur.y + 1 < M && map[cur.x][cur.y + 1] == 1) {
						System.out.println(clean);
						return;
					} else {
						que.add(new Move(cur.x, cur.y + 1, 3));
//						System.out.println("서"+(cur.x) + " " + (cur.y + 1));
					}
					break;
				}

				}
			}
//			System.out.println("-----------------");

		}
		System.out.println(clean);
	}
}