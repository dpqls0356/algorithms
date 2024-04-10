
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {
    static int N;
    static int M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        re(cnt, 1);
        System.out.println(sb.toString());
    }

    public static void re(int cnt, int before) {
        if (cnt == M) {
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
        } else {
            // i를 cnt로 할 경우 자리 숫자보다 큰 경우부터 N보다 작거나 같은 범위면 숫자를 사용할 수 있기에
            // 원하는 방향으로 나오지않는 것 ...
            // 오름차순 = 이전 숫자보다 크다. 라는 것에 초점을 맞춰 풀었어야했다.
            for (int i = before; i <= N; i++) {
                if (!visited[i - 1]) {
                    // System.out.println("test " + cnt + " " + i + " " + !visited[i - 1]);
                    arr[cnt] = i;
                    before = i;
                    visited[i - 1] = true;
                    re(cnt + 1, before + 1);
                    visited[i - 1] = false;
                }

            }
        }
    }
}
