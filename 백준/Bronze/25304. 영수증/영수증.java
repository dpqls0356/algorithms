import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long X = sc.nextLong();
        int N = sc.nextInt();
        
        long totalCalculated = 0;
        
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            totalCalculated += (long) a * b;
        }
        
        if (totalCalculated == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
}