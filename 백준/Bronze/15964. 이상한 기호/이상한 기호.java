import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        long result = calculateCustomOperator(A, B);
        
        System.out.println(result);
        
        scanner.close();
    }
    
    public static long calculateCustomOperator(int A, int B) {
        return (long)(A + B) * (A - B);
    }
}