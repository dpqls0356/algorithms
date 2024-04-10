
import java.util.Scanner;

public class BJ2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sP = 1;
        long eP = 1;
        long N = sc.nextLong();
        // 자기자신을 가르키는 경우의 수 1개
        long count = 1;
        // sp,ep 모두 처음엔 1을 가르키기에 sum은 1
        long sum = 1;
        while (sP < N && eP < N) {
            if (sum < N) {
                eP++;
                sum += eP;
            } else if (sum > N) {
                sum -= sP;
                sP++;
            } else if (sum == N) {
                count++;
                sum -= sP;
                sP++;
            }

        }
        System.out.println(count);
    }
}
