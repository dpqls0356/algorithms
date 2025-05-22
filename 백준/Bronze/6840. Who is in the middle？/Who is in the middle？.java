import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] weights = new int[3];
        weights[0] = sc.nextInt();
        weights[1] = sc.nextInt();
        weights[2] = sc.nextInt();
        Arrays.sort(weights);
        System.out.println(weights[1]);
    }
}
