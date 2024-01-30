
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int k = 0; k < t; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) {
                    sum += num;
                }
            }
            System.out.println("#" + (k + 1) + " " + sum);
        }
    }
}
