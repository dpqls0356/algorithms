package BJ;

import java.util.Scanner;

public class BJ1546_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] score = new double[N];
        double Maxscore = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextDouble();
            if (Maxscore < score[i])
                Maxscore = score[i];
        }
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += score[i] / Maxscore * 100;
        }
        System.out.println(sum / N);
    }
    // (a/m*100 + b/m*100 + c/m*100 ) / 3 = (a+b+c)*100/m/3
}
