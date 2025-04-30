import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        double[] scores = new double[n];
        
        double maxScore = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextDouble();
            maxScore = Math.max(maxScore, scores[i]);
        }
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scores[i] / maxScore * 100;
            sum += scores[i];
        }
        
        double average = sum / n;
        System.out.println(average);
        
        scanner.close();
    }
}