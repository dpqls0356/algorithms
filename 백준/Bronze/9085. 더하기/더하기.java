import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }

        sc.close();
    }
}
