
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ15663 {
    public static int N;
    public static int M;
    public static int arr[];
    public static boolean visited[];
    public static int maxNum = 0;
    public static int returnArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        returnArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (maxNum < arr[i])
                maxNum = arr[i];
        }

        visited = new boolean[maxNum + 1];
        for (int i = 0; i < N; i++) {
            visited[arr[i]] = true;
        }
        find(0, 0);

    }

    public static void find(int start, int cnt) {
        if (cnt == M) {
            for (int num : returnArr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = start + 1; i <= maxNum; i++) {
                if (visited[i]) {
                    // System.out.println("-" + i + " " + cnt);
                    returnArr[cnt] = i;
                    visited[i] = false;
                    find(i, cnt + 1);
                }
            }

        }
    }
}
