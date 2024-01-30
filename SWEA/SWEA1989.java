
import java.io.BufferedReader;
import java.util.Scanner;

public class SWEA1989 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            int count = 0;
            for (int k = 0; k < str.length() / 2; k++) {
                if (str.charAt(k) == str.charAt(str.length() - k - 1)) {
                    count++;
                }
            }
            if (count == str.length() / 2) {
                System.out.println("#" + (i + 1) + " 1");
            } else {
                System.out.println("#" + (i + 1) + " 0");
            }
        }
    }
}
