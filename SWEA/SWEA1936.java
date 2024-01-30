
import java.util.*;

public class SWEA1936 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 2-1 = 1 3-2 =1 1-3= -2
        // 1-2 = -1 2-3 = -1 3-1 =2

        int A = sc.nextInt();
        int B = sc.nextInt();
        if (A - B == 1 || A - B == -2) {
            System.out.print("A");
        } else if (A - B == -1 || A - B == 2) {
            System.out.print("B");
        }
    }
}
