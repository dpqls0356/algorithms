import java.io.*;
import java.util.*;

/*
원래 벽부이2 코드에
시간이라는 개념을 추가
시간이 홀수면 낮
시간이 짝수면 밤

단 주의할점이
밤일 때도 벽이 아니면 움직일수있어야함


*/
public class Main {
    
    private static int N, M, K;
    private static int[][] arr;
    private static boolean[][][] visited;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int count = method(0, 0, K);
        System.out.println(count);
    }

    private static int method(int y, int x, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 1, k, 1});
        visited[y][x][k] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int curY = temp[0], curX = temp[1], dist = temp[2], curK = temp[3], time = temp[4];

            if (curY == N - 1 && curX == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int goY = curY + dy[i];
                int goX = curX + dx[i];

                if (goY >= 0 && goX >= 0 && goY < N && goX < M) {
                    if (arr[goY][goX] == 0 && !visited[goY][goX][curK]) {
                        visited[goY][goX][curK] = true;
                        q.add(new int[]{goY, goX, dist + 1, curK, time + 1});
                    }
                    else if (arr[goY][goX] == 1 && curK > 0 && !visited[goY][goX][curK - 1]&&time % 2 == 1) {
                        visited[goY][goX][curK - 1] = true;
                        q.add(new int[]{goY, goX, dist + 1, curK - 1, time + 1});
                    }
                    else if(arr[goY][goX] == 1 && curK > 0 && !visited[goY][goX][curK - 1]&&time % 2 == 0) { // 밤이면 제자리에서 대기
                            q.add(new int[]{curY, curX, dist + 1, curK, time + 1});
                        }
                    }
                }
            }
        return -1;
    }
}
