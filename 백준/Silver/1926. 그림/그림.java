import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] arr;
  static boolean[][] visited;
  static int maxSize = Integer.MIN_VALUE;
  static int print = 0;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < M; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int k = 0; k < M; k++) {
        if (!visited[i][k] && arr[i][k] == 1 )  {
          BFS(i, k);
          print++;
        }
      }
    }
    if(print==0)System.out.println("0\n0");
    else System.out.println(print + "\n" + maxSize);

  }

  public static void BFS(int i, int k) {

    Queue<int[]> que = new ArrayDeque<>();
    que.add(new int[] { i, k });
    visited[i][k] = true;
    int size = 1;
    while (!que.isEmpty()) {
      int cur[] = que.poll();
      int curX = cur[0];
      int curY = cur[1];
      int dx[] = { 0, 1, 0, -1 };
      int dy[] = { 1, 0, -1, 0 };
      for (int a = 0; a < 4; a++) {
        int x = curX + dx[a];
        int y = curY + dy[a];
        if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y] && arr[x][y] == 1) {
          visited[x][y] = true;
          que.add(new int[] { x, y });
          size++;
        }
      }
    }
    if (maxSize < size)
      maxSize = size;
  }
}