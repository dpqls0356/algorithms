
import java.util.Scanner;

public class SWEA2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += (n.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}
