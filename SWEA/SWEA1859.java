
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws IOException {
        // N일동안 매매가 예측함
        // 하루에 1개가 최대 구매개수
        // 여러 개 판매는 가능

        // T
        // N = 2~백만개 (int로 불가)
        // 매매가 입력 ( 공백으로 분리 - 10000이하)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int price[] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                price[k] = Integer.parseInt(st.nextToken());
            }
            int big = 0;
            long result = 0;
            for (int k = N - 1; k >= 0; k--) {
                if (big < price[k])
                    big = price[k];
                else {
                    result += (big - price[k]);
                }
            }
            System.out.println("#" + (i + 1) + " " + result);
        }

    }
}
