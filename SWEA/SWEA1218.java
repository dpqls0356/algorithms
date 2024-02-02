
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA1218 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            // 유효성 검사코드
            int res = 1;

            // 문자열 길이
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Stack<String> q = new Stack<String>();
            if (len % 2 != 0) {
                res = 0;
            }
            // 문자열 받기
            else {
                for (int k = 0; k < str.length(); k++) {
                    String check = str.substring(k, k + 1);
                    if (check.contains("<") || check.contains("{") || check.contains("[") || check.contains("(")) {
                        q.add(check);
                        continue;
                    }
                    if (!q.isEmpty() && ((check.equals(">") && q.pop().equals("<"))
                            || (check.equals("]") && q.pop().equals("[")) || (check.equals("}") && q.pop().equals("{"))
                            || (check.equals(")") && q.pop().equals("(")))) {
                        continue;
                    } else {
                        res = 0;
                        // System.out.println(k+" "+res);
                        break;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + res);

        }
    }
}
