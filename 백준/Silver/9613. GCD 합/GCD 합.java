import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }
            
            long sum = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += gcd(numbers[j], numbers[k]);
                }
            }
            
            System.out.println(sum);
        }
        
        sc.close();
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}