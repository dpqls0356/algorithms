import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean visited[][];
    static int list[][];
    static Queue<int[]> que = new LinkedList<int[]>();
    static int[] x = { 1, 0, -1, 0 };
    static int[] y = { 0, 1, 0, -1 };
    static int H, W;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T > 0) {
            // 배추농장 만들기
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());
            list = new int[H][W];
            visited = new boolean[H][W];
            for (int i = 0; i < cabbage; i++) {
                st = new StringTokenizer(br.readLine());
                list[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            // 모여있는 배추의 수 구하기
            int land = 0;
            // System.out.println();
            // for (int i = 0; i < H; i++) {
            // for (int k = 0; k < W; k++) {
            // System.out.print(list[i][k] + " ");
            // }
            // System.out.println();
            // }
            for (int i = 0; i < H; i++) {
                for (int k = 0; k < W; k++) {
                    if (!visited[i][k] && list[i][k] == 1) {
                        // System.out.println(i + " " + k + "pick");
                        que.add(new int[] { i, k });
                        bfs();
                        land++;
                    }
                }
            }
            sb.append(land + "\n");
            T--;
            // System.out.println("-----------------------");
        }
        System.out.print(sb);
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            int cur[] = que.poll();
            for (int i = 0; i < x.length; i++) {
                int dx = cur[0] + x[i];
                int dy = cur[1] + y[i];
                if (dx >= 0 && dx < H && dy >= 0 && dy < W && !visited[dx][dy] && list[dx][dy] == 1) {
                    que.add(new int[] { dx, dy });
                    visited[dx][dy] = true;
                }
            }
        }
    }
}
