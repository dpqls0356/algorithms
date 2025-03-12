import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            
            System.out.print("*");
            
            for (int j = 0; j < 2 * (i - 1) - 1; j++) {
                System.out.print(" ");
            }
            
            if (i > 1) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        if (n > 0) {
            for (int i = 0; i < 2 * n - 1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}