
import java.math.BigInteger;
import java.util.Scanner;

public class SWEA17937 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        BigInteger arr[] = new BigInteger[T];
        for (int i = 0; i < T; i++) {
            String a = sc.next();
            String b = sc.next();
            BigInteger bda = new BigInteger(a);
            BigInteger bdb = new BigInteger(b);
            for (BigInteger k = bda; k.compareTo(BigInteger.valueOf(0)) != 0; k = k.add(BigInteger.valueOf(-1))) {
                if (bdb.mod(k) == BigInteger.valueOf(0)) {
                    arr[i] = k;
                    break;
                }
            }
        }
        for (int i = 0; i < T; i++) {
            System.out.println("#" + (i + 1) + " " + arr[i]);
        }
        sc.close();
        // 아 진심 개빡친다 ㅎㅎ 최대 공약수 구하는 코드 짜놨더니 실제로 구해야하는건 최소 결함의 수네 ㅋㅋㅋt발 ...
        // Scanner sc = new Scanner(System.in);
        // int T;
        // T=sc.nextInt();

        // for(int test_case = 1; test_case <= T; test_case++)
        // {
        // String a = sc.next();
        // String b = sc.next();

        // if(a.equals(b)) {
        // System.out.println("#" + test_case + " " + a);
        // }
        // else {
        // System.out.println("#" + test_case + " " + 1);
        // }

        // }
    }
}
