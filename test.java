import java.util.*;

public class test {
    static int parents[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        makeSet(N);
        int parent = find(5);
        union(3, 2);
    }

    public static void makeSet(int N) {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = N;
        }
    }

    public static int find(int x) {
        return parents[x] = parents[x] == x ? x : find(parents[x]);
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY)
            return false;
        else {
            parents[rootY] = rootX;
            return true;
        }
    }

}