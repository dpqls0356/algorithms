
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//  버블 / 선택 / 퀵 / 삽입 / 기수 / 병합 으로 구현해보기
public class SWEA2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt((st.nextToken()));
            for (int k = 1; k < 10; k++) {
                int num = Integer.parseInt(st.nextToken());
                if (big < num)
                    big = num;
            }
            System.out.println("#" + (i + 1) + " " + big);
        }
    }
}
