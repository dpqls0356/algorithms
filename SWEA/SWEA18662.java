import java.util.Scanner;

// 등차수열을 최소한의 연산으로 만들기 : a와 c의 중간값이 b이어야한다.
public class SWEA18662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        double arr[] = new double[T];
        for (int i = 0; i < T; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();
            if (2 * b == a + c) {
                arr[i] = 0;
            } else {
                double re = (a + c) / 2;
                arr[i] = Math.abs(b - re);
            }
        }
        for (int k = 0; k < T; k++) {
            System.out.printf("#" + (k + 1) + " " + "%.1f\n", arr[k]);
        }
        sc.close();
    }
}
