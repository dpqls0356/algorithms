
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = N / 5; i >= 0; i--) {
            if ((N - i * 5) % 3 == 0) {
                if (min > i + (N - i * 5) / 3)
                    min = i + (N - i * 5) / 3;
            }
        }
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
