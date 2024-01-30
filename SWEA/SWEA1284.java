
import java.io.*;
import java.util.*;

public class SWEA1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 1; i < T + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int A = w * p;
            int B;
            if (w <= r) {
                B = q;
            } else {
                B = q + (w - r) * s;
            }
            System.out.printf("#%d %d\n", i, A > B ? B : A);
        }
    }
}
