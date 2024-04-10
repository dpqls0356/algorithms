
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제번호 : BJ1012
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 성능
 * 메모리 : 16268 KB , 시간: 188 ms , 코드길이: 2667 B
 * 
 * 문제접근
 * BFS
 * 섬의 개수(BJ4963) 구하는 문제랑 같은 문제
 * 
 */
public class BJ1012 {
    static boolean visited[][]; // 방문여부를 체크할 배열
    static int list[][]; // 배추농장의 정보를 담을 배열
    static Queue<int[]> que = new LinkedList<int[]>(); // bfs를 구현하기 위해 필요한 큐
    static int[] x = { 1, 0, -1, 0 }; // 방향
    static int[] y = { 0, 1, 0, -1 };
    static int H, W; // 배추농장의 크기

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
                        // 현재위치 큐에 넣기
                        que.add(new int[] { i, k });
                        // 인접한 배추들 찾아서 방문 표시하기
                        bfs();
                        // bfs가 한 번 끝났다 -> 현재 위치를 기준으로 인접한 배추는 다 방문했다.
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
                // 어떤 위치로 이동할지 결정
                int dx = cur[0] + x[i];
                int dy = cur[1] + y[i];
                // 아직 방문하지않았고 그 위치에 배추가 있는 경우
                if (dx >= 0 && dx < H && dy >= 0 && dy < W && !visited[dx][dy] && list[dx][dy] == 1) {
                    que.add(new int[] { dx, dy });
                    visited[dx][dy] = true;
                }
            }
        }
    }
}
