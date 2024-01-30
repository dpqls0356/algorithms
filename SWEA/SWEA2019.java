
import java.util.Scanner;

public class SWEA2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i <= T; i++) {
            System.out.print(Math.pow(2, i) + " ");
        }
    }
}
