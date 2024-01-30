package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  이 문제는 BFS + 방향 조절이 관건!
public class BJ2178 {
    // 상하좌우 판별 상 우 하 좌
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int Arr[][];
    static boolean visited[][];
    static int N, M;

    static void BFS(int i, int j) {
        // 좌표값을 넣는 큐를 만듦
        Queue<int[]> que = new LinkedList<>();
        // 시작 좌표 넣기
        que.add(new int[] { i, j });
        visited[i][j] = true;
        // 큐이 빈다 = 전부 탐색한 것
        while (!que.isEmpty()) {
            // 현재 큐 front에 담긴 좌표 꺼내기
            int now[] = que.poll();
            // 상하좌우 살피면서 이동
            for (int k = 0; k < 4; k++) {
                // 이동할 위치의 좌표
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                // 상 우 하 좌
                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (Arr[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        // 이동할 위치의 좌표 값을 현재 위치값의 depth+1
                        Arr[x][y] = Arr[now[0]][now[1]] + 1;
                        // 큐에 좌표 넣기
                        que.add(new int[] { x, y });
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int k = 0; k < M; k++) {
                Arr[i][k] = Integer.parseInt(line.substring(k, k + 1));
            }
        }
        BFS(0, 0);
        System.out.println(Arr[N - 1][M - 1]);
    }
}

// 코드의 문제점 : 인접리스트를 가지고 푸는 문제가 아니었다.
// 인접리스트로 풀려면 하단으로 내려갈때와 올라갈때 depth를 설정해줘야함

// public class ex2178 {
// static Scanner sc = new Scanner(System.in);
// private int root[][];
// private ArrayList<Integer> arr[];
// private boolean visited[];
// private Queue<Integer> que = new LinkedList<>();
// private int count = 0;
// private boolean endch = false;

// ex2178(int n, int m) {
// arr = new ArrayList[n * m + 1];
// visited = new boolean[n * m + 1];
// root = new int[n + 1][m + 1];
// // 초기화
// for (int i = 1; i < n * m + 1; i++) {
// arr[i] = new ArrayList<Integer>();
// }
// for (int i = 1; i < n + 1; i++) {
// String number = sc.nextLine();
// for (int k = 1; k < m + 1; k++) {
// root[i][k] = number.charAt(k - 1) - '0';
// }
// }
// for (int i = 1; i < n + 1; i++) {
// for (int k = 1; k < m + 1; k++) {
// // 아래쪽
// if (i + 1 < n + 1 && root[i + 1][k] == 1) {
// arr[(i - 1) * m + k].add(i * m + k);
// }
// // 오른쪽 확인
// if (k + 1 < m + 1 && root[i][k + 1] == 1) {
// arr[(i - 1) * m + k].add((i - 1) * m + k + 1);
// }
// // 왼쪽
// if (k - 1 > 0 && root[i][k - 1] == 1) {
// arr[(i - 1) * m + k].add((i - 1) * m + k - 1);
// }
// // 위쪽
// if (i - 1 > 0 && root[i - 1][k] == 1) {
// arr[(i - 1) * m + k].add((i - 2) * m + k);
// }
// }
// }
// // 출력
// // for (int i = 1; i < n + 1; i++) {
// // for (int k = 1; k < m + 1; k++) {
// // System.out.print(root[i][k]);
// // }
// // System.out.println();
// // }
// // for (int i = 1; i < n * m + 1; i++) {
// // System.out.print("arraylist[" + i + "]: ");
// // for (int k : arr[i]) {
// // System.out.print(k);
// // }
// // System.out.println(" ");
// // }

// }

// void BFS(int n, int m) {
// for (int startnode = 1; startnode < n * m + 1; startnode++) {
// if (!visited[startnode]) {
// BFSRUN(startnode, n, m);
// }
// if (endch == true)
// return;
// }
// }

// void BFSRUN(int startnode, int n, int m) {
// if (!visited[startnode] && !endch) {
// count++;
// visited[startnode] = true;
// for (int i : arr[startnode]) {
// if (i == n * m) {
// endch = true;
// } else {
// BFSRUN(i, n, m);
// }
// }
// }
// }

// public static void main(String[] args) {
// int n = sc.nextInt();
// int m = sc.nextInt();
// sc.nextLine();
// ex2178 bfs = new ex2178(n, m);
// bfs.BFS(n, m);
// System.out.println(bfs.count);
// }
// }
