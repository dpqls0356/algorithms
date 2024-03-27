import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;

        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int runCase = 1;
        while (n != 0) {
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    map[i][k] = Integer.parseInt(st.nextToken());
                }
            }
            int result = bfs();
            sb.append("Problem " + runCase + ": " + result + "\n");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            runCase++;
        }
        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        int[][] move = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        q.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!q.isEmpty()) {
            Node pos = q.poll();
            int px = pos.x, py = pos.y;
            int cost = pos.cost;

            if (px == n - 1 && py == n - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1)
                    continue;

                if (cost + map[ny][nx] < move[ny][nx]) {
                    move[ny][nx] = cost + map[ny][nx];
                    q.add(new Node(nx, ny, cost + map[ny][nx]));
                }

            }
        }
        return -1;
    }
}