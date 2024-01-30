
import java.util.*;
import java.io.*;

public class SWEA2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String al = st.nextToken();
        for (int i = 0; i < al.length(); i++) {
            System.out.print(al.charAt(i) - 'A' + 1);
            System.out.print(" ");
        }
    }
}
