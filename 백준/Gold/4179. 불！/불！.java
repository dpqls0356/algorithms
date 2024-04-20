import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static char[][] arr;
  static boolean[][] visited;
  static int N, M;
  static int jiHunX;
  static int jiHunY;
  static Queue<int[]> que2 = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new char[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int k = 0; k < M; k++) {
        arr[i][k] = str.charAt(k);
        if (arr[i][k] == 'J') {
          jiHunX = i;
          jiHunY = k;
          arr[i][k] = '.';

        }
        if (arr[i][k] == 'F') {
          que2.add(new int[] { i, k });
        }
      }
    }
    if (jiHunX == 0 || jiHunX == N - 1 || jiHunY == 0 || jiHunY == M - 1) {
      System.out.println(1);
      return;
    }
    BFS();

  }

  public static void BFS() {
    int dx[] = { 0, 1, 0, -1 };
    int dy[] = { 1, 0, -1, 0 };

    Queue<int[]> que = new ArrayDeque<>();
    que.add(new int[] { jiHunX, jiHunY, 0 });
    visited[jiHunX][jiHunY] = true;

    while (!que.isEmpty()) {
      int fireCount = que2.size();
      // System.out.println();
      // for (int i = 0; i < N; i++) {
      // for (int k = 0; k < M; k++) {
      // System.out.print(arr[i][k] + " ");
      // }
      // System.out.println();
      // }
      int cur[] = que.poll();
      int curX = cur[0];
      int curY = cur[1];

      if (curX == 0 || curX == N - 1 || curY == 0 || curY == M - 1) {
        if (arr[curX][curY] != 'F') {
          System.out.println(cur[2] + 1);
          return;
        } else
          continue;
      }

      for (int a = 0; a < 4; a++) {

        int x = curX + dx[a];
        int y = curY + dy[a];

        if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && arr[x][y] == '.') {
          visited[x][y] = true;
          que.add(new int[] { x, y, cur[2] + 1 });
        }
      }
      if(!que.isEmpty()){
        int next[] = que.peek();
        if (next[2] == cur[2] + 1) {
          for (int i = 0; i < fireCount; i++) {
            int cur2[] = que2.poll();
            for (int j = 0; j < 4; j++) {
              int x = cur2[0] + dx[j];
              int y = cur2[1] + dy[j];
              if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == '.') {
                que2.add(new int[] { x, y });
                arr[x][y] = 'F';
              }
            }
          }
        }
      }
    }
    System.out.println("IMPOSSIBLE");
  }
}