
import java.io.*;
import java.util.*;

public class Solution {

    static int arr[][];
    static int copy[][];
    static int N;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int k = 0; k < N; k++) {
                    arr[i][k] = str.charAt(k) - '0';
                    copy[i][k] = Integer.MAX_VALUE;
                }
            }
            // for (int i = 0; i < N; i++) {
            // for (int k = 0; k < N; k++) {
            // System.out.print(arr[i][k] + " ");
            // }
            // System.out.println();
            // }
            BFS();

            System.out.println("#" + t + " " + copy[N - 1][N - 1]);
        }

    }

    public static void BFS() {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] { 0, 0 });
        copy[0][0] = 0;
        while (!que.isEmpty()) {
            int cur[] = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int x = curX + dx[i];
                int y = curY + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < N) {
                    if (copy[x][y] > copy[curX][curY] + arr[x][y]) {
                        copy[x][y] = copy[curX][curY] + arr[x][y];
                        que.add(new int[] { x, y });
                    }
                }
            }

        }
    }
}