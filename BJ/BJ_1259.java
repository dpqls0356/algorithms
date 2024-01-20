package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            if (Long.parseLong(num) == 0) {
                break;
            }
            for (int i = 0; i <= num.length() / 2; i++) {
                if (num.charAt(i) != num.charAt(num.length() - i - 1) || num.charAt(0) == '0') {
                    System.out.println("no");
                    break;
                }
                if (i + 1 >= num.length() / 2) {
                    System.out.println("yes");
                    break;
                }
            }
        }
    }
}
