import java.io.*;
import java.util.*;

public class Main {
    static int parents[];
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        makeSet();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cal == 0) {
                union(a, b);
            } else if (cal == 1) {
                if (find(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    public static void makeSet() {
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static void union(int a, int b) {
        int rootA = isParent(a);
        int rootB = isParent(b);
        // System.out.println("union " + rootA + " " + rootB);
        if (rootA > rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
        // for (int i = 0; i <= N; i++) {
        // System.out.print(parents[i] + " ");
        // }
        // System.out.println();
    }

    public static boolean find(int a, int b) {
        int rootA = isParent(a);
        int rootB = isParent(b);
        // System.out.println("find " + rootA + " " + rootB);
        if (rootA != rootB) {
            return false;
        }
        return true;
    }

    public static int isParent(int a) {
        return parents[a] = (a == parents[a] ? a : isParent(parents[a]));
    }
}