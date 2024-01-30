
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int re = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = num; i < 999; i++) {
            count++;
            if (i == re) {
                System.out.print(count);
                break;
            }
        }
    }
}
