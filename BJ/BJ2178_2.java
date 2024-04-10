
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

/**
 * 문제번호 : BJ2178
 * 주석 작성자 : 이예빈
 * 결과 : 맞았습니다.
 * 성능
 * 메모리 : KB , 시간: ms , 코드길이: B
 * 
 * 문제접근
 * 
 * 
 */

public class BJ2178_2 {

    public static int N;
    public static int M;
    public static int dx[] = { 1, 0, -1, 0 };
    public static int dy[] = { 0, 1, 0, -1 };
    public static boolean visited[][];
    public static int arr[][];

    public static void dfs(int n, int m) {
        for (int i = 0; i < 4; i++) {
            int x = n + dx[i];
            int y = m + dy[i];
            if (y >= 0 && y < N && x >= 0 && x < M) {
                if (!visited[y][x]) {
                    // System.out.println(x + " " + y);
                    visited[y][x] = true;
                    arr[y][x] = arr[n][m] + 1;
                    dfs(x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열의 크기 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        // 배열의 데이터 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int k = 0; k < M; k++) {
                arr[i][k] = str.charAt(k) - '0';
            }
        }
        dfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }
}
