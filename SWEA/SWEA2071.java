
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            double sum = 0;
            for (int k = 0; k < 10; k++) {
                sum += Double.parseDouble(st.nextToken());
            }
            System.out.println("#" + (i + 1) + " " + Math.round(sum / 10));
        }
    }
}
