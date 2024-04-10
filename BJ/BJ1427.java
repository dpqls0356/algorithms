
import java.util.Scanner;

// 선택정렬
//  N이 최대10자리 수이기때문에 N^2를 해도 상관없음
public class BJ1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int arr[] = new int[num.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - 48;
        }
        for (int i = 0; i < num.length(); i++) {
            int bigger = arr[i];
            int biggerIndex = i;
            for (int k = i; k < num.length(); k++) {
                if (bigger < arr[k]) {
                    biggerIndex = k;
                    bigger = arr[k];
                }
            }
            int swap = arr[i];
            arr[i] = arr[biggerIndex];
            arr[biggerIndex] = swap;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
}
