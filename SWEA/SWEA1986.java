
import java.util.Scanner;

public class SWEA1986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            int sum = 0;
            for (int k = 1; k <= num; k++) {
                if (k % 2 == 0) {
                    sum -= k;
                } else {
                    sum += k;
                }
            }
            System.out.println("#" + (i + 1) + " " + sum);
        }
    }
}
