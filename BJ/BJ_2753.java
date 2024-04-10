
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 윤년을 판단할 년도 입력받기
        int year = Integer.parseInt(st.nextToken());
        // 윤년일 때 1 출력
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(1);
        }
        // 윤년이 아닐 때 0출력
        else {
            System.out.println(0);
        }
    }
}
