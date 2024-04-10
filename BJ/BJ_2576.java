
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int size = 7;
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 != 0) {
                if (min > num)
                    min = num;
                sum += num;
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }
    }
}
