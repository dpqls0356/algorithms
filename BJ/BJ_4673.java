
public class BJ_4673 {
    public static void main(String args[]) {
        boolean visited[] = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            int singleDigit = i;
            int sum = i;
            while (singleDigit != 0) {
                sum = (sum + singleDigit % 10);
                singleDigit /= 10;
            }
            if (sum < 10001 && !visited[sum])
                visited[sum] = true;
        }
        for (int i = 1; i < 10001; i++) {
            if (!visited[i]) {
                System.out.println(i);
            }
        }
    }
}
