
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int A, B, C;
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int ACup = 0;
        int BCup = 0;
        int CCup = C;
        // A가득채우기
        ACup = A > C ? C : A;
        CCup = A > C ? 0 : C - A;
        if (!list.contains(CCup))
            list.add(CCup);
        // C를 B로 옮기기
        BCup = B > CCup ? CCup : CCup - B;
    }
}
