
import java.util.*;

public class BJ_10808 {
    public static void main(String[] args) {
        // BJ_10808
        // 주석 작성자 : 이예빈
        // 결과 메모리 시간 길이
        // 맞았습니다!! 18276kb 220ms 614
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int size = (int) 'z' - (int) 'a' + 1;
        int arr[] = new int[size];
        for (int i = 0; i < str.length(); i++) {
            arr[(int) str.charAt(i) - 97]++;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
