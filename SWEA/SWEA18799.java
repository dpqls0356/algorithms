import java.util.Scanner;

public class SWEA18799 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int totaltc = sc.nextInt();
        double arr[] = new double[totaltc];

        for (int i = 1; i < totaltc + 1; i++) {
            int tc = sc.nextInt();
            // if (tc <= 0 || tc >= 9) {
            // i--;
            // continue;
            // }
            double sum = 0;
            for (int k = 0; k < tc; k++) {
                int num = sc.nextInt();
                // if (num < -1000 || num > 1000) {
                // k--;
                // continue;
                // }
                sum += num;
            }
            arr[i - 1] = sum / tc;
        }
        // System.out.println(".");
        for (int i = 0; i < totaltc; i++) {
            System.out.print("#" + (i + 1) + " ");
            if ((int) arr[i] != arr[i] && arr[i] != 0) {
                String checknum = Double.toString(arr[i]);
                if (checknum.length() > 23) {
                    System.out.println(String.format("%.20f", arr[i]));
                } else {
                    System.out.println(arr[i]);
                }
            } else {
                System.out.println((int) arr[i]);
            }
        }

    }
}