import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean visitied[];
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visitied = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        res(0, "");
        System.out.print(sb);
    }

    public static void res(int cnt, String str) {
        if (cnt == M) {
            if (!list.contains(str)) {
                list.add(str);
                sb.append(str + "\n");
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (!visitied[i]) {
                    visitied[i] = true;
                    res(cnt + 1, str + arr[i] + " ");
                    visitied[i] = false;
                }
            }
        }
    }
}
