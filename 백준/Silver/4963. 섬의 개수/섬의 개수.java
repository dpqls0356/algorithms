import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            int islandCount = countIslands(map, w, h);
            System.out.println(islandCount);
        }

        scanner.close();
    }

    static int countIslands(int[][] map, int w, int h) {
        boolean[][] visited = new boolean[h][w];
        int islandCount = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(map, visited, i, j, w, h);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    static void bfs(int[][] map, boolean[][] visited, int startX, int startY, int w, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && 
                    map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}