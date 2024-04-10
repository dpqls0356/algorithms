
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15686 {
    static int N, M;
    static int arr[][];
    static int home[];
    static int store[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if (arr[i][k] == 1) {

                } else if (arr[i][k] == 2) {

                }
            }
        }

    }
}
