import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();
            
            int W = A * (X - 1) + B;
            System.out.println(W);
        }
        
        sc.close();
    }
}