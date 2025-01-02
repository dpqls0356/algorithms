import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] stones = new int[M];
        int total = 0;
        
        for (int i = 0; i < M; i++) {
            stones[i] = sc.nextInt();
            total += stones[i];
        }
        
        int K = sc.nextInt();
        double probability = 0.0;
        
        for (int i = 0; i < M; i++) {
            if (stones[i] >= K) {
                probability += combination(stones[i], K);
            }
        }
        
        double totalComb = combination(total, K);
        System.out.println(probability / totalComb);
    }
    
    private static double combination(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        
        double result = 1.0;
        for (int i = 1; i <= r; i++) {
            result *= (n - i + 1);
            result /= i;
        }
        return result;
    }
}