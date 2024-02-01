import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // ACGT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char chars[] = new char[S];
        String str = new StringTokenizer(br.readLine()).nextToken();
        for (int i = 0; i < S; i++) {
            chars[i] = str.charAt(i);
        }

        int arr[] = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int checkarr[] = new int[4];
        int result = 0;
        for (int i = 0; i < S - P + 1; i++) {
            if (i == 0) {
                for (int k = 0; k < P; k++) {
                    // System.out.println(
                    // chars[k] + " " + (chars[k] == 'A') + " " + (chars[k] == 'C') + " "
                    // + (chars[k] == 'G')
                    // + " "
                    // + (chars[k] == 'T'));
                    if (chars[k] == 'A')
                        checkarr[0]++;
                    else if (chars[k] == 'C')
                        checkarr[1]++;
                    else if (chars[k] == 'G')
                        checkarr[2]++;
                    else if (chars[k] == 'T')
                        checkarr[3]++;
                }
            } else {
                // System.out.println(
                // chars[i - 1] + " " + (chars[i - 1] == 'A') + " " + (chars[i - 1] == 'C') + "
                // "
                // + (chars[i - 1] == 'G')
                // + " "
                // + (chars[i - 1] == 'T'));
                if (chars[i - 1] == 'A')
                    checkarr[0]--;
                else if (chars[i - 1] == 'C')
                    checkarr[1]--;
                else if (chars[i - 1] == 'G')
                    checkarr[2]--;
                else if (chars[i - 1] == 'T')
                    checkarr[3]--;
                // System.out.println(
                // chars[P + i - 1] + " " + (chars[P + i - 1] == 'A') + " " + (chars[P + i - 1]
                // == 'C') + " "
                // + (chars[P + i - 1] == 'G')
                // + " "
                // + (chars[P + i - 1] == 'T'));
                if (chars[P + i - 1] == 'A')
                    checkarr[0]++;
                else if (chars[P + i - 1] == 'C')
                    checkarr[1]++;
                else if (chars[P + i - 1] == 'G')
                    checkarr[2]++;
                else if (chars[P + i - 1] == 'T')
                    checkarr[3]++;
            }
            int ch = 0;
            for (int k = 0; k < 4; k++) {
                // System.out.println(arr[k] + " " + checkarr[k]);
                if (arr[k] <= checkarr[k])
                    ch++;
            }
            if (ch == 4)
                result++;
        }
        System.out.println(result);
    }
}
