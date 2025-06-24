import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        double revolutions = (double) n / 4;
        
        System.out.printf("%.2f\n", revolutions);
        
        sc.close();
    }
}