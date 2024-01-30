
import java.util.*;

public class SWEA2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            String inputdata = sc.nextLine();
            int m = inputdata.charAt(5) - '0';
            int d = 10 * (inputdata.charAt(6) - '0') + inputdata.charAt(7) - '0';
            System.out.print("#" + (i + 1) + " ");
            if (m < 1 || m > 12 || month[m] < d) {
                System.out.print("-1\n");
            } else {
                System.out.print(
                        inputdata.substring(0, 4) + "/" + inputdata.substring(4, 6) + "/" + inputdata.substring(6, 8)
                                + "\n");
            }
        }
    }
}
