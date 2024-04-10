
import java.util.Scanner;

public class BJ_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // A값 받기
        int A = sc.nextInt();
        // B값 받기
        int B = sc.nextInt();
        // A가 B보다 큰 경우
        if (A > B) {
            System.out.println(">");
        }
        // A가 B보다 작은 경우
        else if (B > A) {
            System.out.println("<");
        }
        // A와 B가 같은 경우
        else {
            System.out.println("==");
        }
        sc.close();
    }
}
