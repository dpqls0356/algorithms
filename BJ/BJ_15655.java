
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// sort해서 순열 풀 듯이 하면 풀 수 있다.
public class BJ_15655 {
    static int N;
    static int M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];
    static int arr[];
    static int inputNum[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        inputNum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputNum);
        re(cnt, 0);
        System.out.println(sb.toString());
    }

    public static void re(int cnt, int before) {
        if (cnt == M) {
            for (int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
        } else {
            for (int i = cnt; i < N; i++) {
                if (!visited[i] && inputNum[i] > before) {
                    arr[cnt] = inputNum[i];
                    visited[i] = true;
                    re(cnt + 1, inputNum[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
