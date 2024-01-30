
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String headline = st.nextToken();
        for (int i = 0; i < headline.length(); i++) {
            if (headline.charAt(i) != '_' && headline.charAt(i) >= 'a' && headline.charAt(i) <= 'z') {
                System.out.print((char) (headline.charAt(i) - 32));
            } else {
                System.out.print(headline.charAt(i));
            }
        }
    }
}
