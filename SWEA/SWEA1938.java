
import java.util.Scanner;

public class SWEA1938 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%d\n%d\n%d\n%d", a + b, a - b, a * b, a / b);
    }
}