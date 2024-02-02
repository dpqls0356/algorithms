import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int xdir[] = { 1, 0, -1, 0 };
            int ydir[] = { 0, 1, 0, -1 };
            int arr[][] = new int[N][N];
            int x = 0;// ----[][!]
            int y = 0;// | [!][]
            int mode = 0;
            int cnt = 2;
            boolean visited[][] = new boolean[N][N];
            arr[0][0] = 1;
            visited[0][0] = true;
            while (cnt <= N * N) {
                if (mode == 0 || mode == 2) {
                    if (x + xdir[mode] > N - 1 || x + xdir[mode] < 0 || visited[y + ydir[mode]][x + xdir[mode]]) {
                        mode++;
                        if (mode / 4 == 1)
                            mode = 0;
                    }
                }
                // |
                else if (mode == 3 || mode == 1) {
                    if (y + ydir[mode] > N - 1 || y + ydir[mode] < 0 || visited[y + ydir[mode]][x + xdir[mode]]) {
                        mode++;
                        if (mode / 4 == 1)
                            mode = 0;
                    }
                }
                arr[y + ydir[mode]][x + xdir[mode]] = cnt;
                visited[y + ydir[mode]][x + xdir[mode]] = true;
                x += xdir[mode];
                y += ydir[mode];
                cnt++;
            }
            System.out.println("#" + (i + 1));
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    System.out.print(arr[a][b] + " ");
                }
                System.out.println();
            }
        }
    }
}
