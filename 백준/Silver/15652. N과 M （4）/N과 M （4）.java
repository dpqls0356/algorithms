
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
            for (int i = before; i <= N; i++) {
                arr[cnt] = i;
                re(cnt + 1, i);
            }
        }
    }
}
