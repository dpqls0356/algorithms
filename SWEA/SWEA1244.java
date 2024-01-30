
import java.util.Scanner;

class SWEA1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String num = sc.next();
            int count = sc.nextInt();
            int arr[] = new int[num.length()];
            for (int k = 0; k < num.length(); k++) {
                arr[k] = Integer.parseInt(num.substring(k, k + 1));
            }
            int con = 0;
            while (count != con) {
                int big = 0;
                for (int k = 0 + con; k < num.length() - con; k++) {
                    if (big < arr[k])
                        big = arr[k];
                }
                for (int k = num.length() - 1 - con; k >= 0 + con; k--) {
                    if (arr[k] == big) {
                        int tmp = arr[k];
                        arr[k] = arr[con];
                        arr[con] = tmp;
                        con++;
                        if (con == count)
                            break;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " ");
            for (int k = 0; k < num.length(); k++) {
                System.out.print(arr[k]);
            }
            System.out.println();
        }
    }
}