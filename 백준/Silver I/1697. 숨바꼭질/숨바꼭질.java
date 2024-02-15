import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean visited[] = new boolean[1000001];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if (K < N) {
            System.out.println(N - K);
            System.exit(0);
        }
        Queue<Integer> position = new LinkedList<>();
        Queue<Integer> cnt = new LinkedList<>();
        position.add(N);
        cnt.add(0);
        while (!position.isEmpty()) {
            int curPosition = position.poll();
            int curCnt = cnt.poll();
            if (curPosition == K) {
                System.out.print(curCnt);
                break;
            }
            if (!visited[curPosition + 1] && curPosition < K) {
                visited[curPosition + 1] = true;
                position.add(curPosition + 1);
                cnt.add(curCnt + 1);
            }
            if (curPosition - 1 >= 0 && !visited[curPosition - 1]) {
                visited[curPosition - 1] = true;
                position.add(curPosition - 1);
                cnt.add(curCnt + 1);
            }
            if (!visited[curPosition * 2] && curPosition < K && curPosition <= 50000) {
                visited[curPosition * 2] = true;
                position.add(curPosition * 2);
                cnt.add(curCnt + 1);
            }
        }
    }
}
