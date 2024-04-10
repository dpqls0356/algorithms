
import java.io.*;
import java.util.*;

public class BJ1987 {
    static int maxLen = 0;
    static String route = "";
    static int x[] = { 1, 0, -1, 0 };
    static int y[] = { 0, 1, 0, -1 };
    static int R, C;
    static boolean visited[][];
    static char arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R + 1][C + 1];
        arr = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int k = 0; k < C; k++) {
                arr[i][k + 1] = str.charAt(k);
            }
        }
        route += arr[1][1];
        visited[1][1] = true;
        DFS(1, 1, 1);
        System.out.print(maxLen);

    }

    static void DFS(int row, int col, int cnt) {
        if (cnt == R * C) {
            if (maxLen < route.length())
                maxLen = route.length();
        } else {
            for (int i = 0; i < 4; i++) {
                int dx = row + x[i];
                int dy = col + y[i];
                if ((dx >= 1 && dx <= R && dy >= 1 && dy <= C && !visited[dx][dy])) {
                    if (route.contains(arr[dx][dy] + "")) {
                        if (maxLen < route.length())
                            maxLen = route.length();
                    } else {
                        route += arr[dx][dy];
                        visited[dx][dy] = true;
                        DFS(dx, dy, cnt + 1);
                        visited[dx][dy] = false;
                        route = route.substring(0, route.length() - 1);
                    }
                }
            }
        }
    }
}
