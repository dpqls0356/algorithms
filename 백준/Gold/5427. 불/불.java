import java.io.*;
import java.util.*;


public class Main {

    static char[][] arr;
    static int N, M;
    static boolean[][] visited;
    static Queue<Spot> queue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Spot {
        int x;
        int y;
        int type; // 0: 상근이, 1: 불
        int cnt;

        public Spot(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new char[N][M];
            visited = new boolean[N][M];
            queue = new ArrayDeque<>();

            Spot start = null;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = line.charAt(j);
                    if (arr[i][j] == '@') {
                        start = new Spot(i, j, 0, 0);
                    } else if (arr[i][j] == '*') {
                        queue.offer(new Spot(i, j, 1, 0));
                    }
                }
            }

            queue.offer(start);
            int result = bfs();
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Spot spot = queue.poll();

            if (spot.type == 0 && (spot.x == 0 || spot.x == N - 1 || spot.y == 0 || spot.y == M - 1)) {
                return spot.cnt + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = spot.x + dx[i];
                int ny = spot.y + dy[i];

                if (spot.type == 1) { // 불의 경우
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && (arr[nx][ny] == '.' || arr[nx][ny] == '@')) {
                        arr[nx][ny] = '*';
                        queue.offer(new Spot(nx, ny, 1, spot.cnt + 1));
                    }
                } else { // 상근이의 경우
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && arr[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.offer(new Spot(nx, ny, 0, spot.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}