
import java.util.Scanner;

public class BJ_2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 2 * T - 2 * i - 1; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < T; i++) {
            for (int j = T - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * (i + 1) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
