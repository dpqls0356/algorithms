import java.io.*;
import java.util.*;

public class BJ1260 {
    static ArrayList<Integer> list[];
    static int N;
    static int E;
    static int start;
    static boolean visited[];
    static boolean visited2[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (!list[a].contains(b)) {
                list[a].add(b);
            }
            if (!list[b].contains(a)) {
                list[b].add(a);
            }
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list[i]);
        }
        DFS(start);
        System.out.println();
        BFS(start);
    }

    public static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < list[node].size(); i++) {
            if (!visited[list[node].get(i)]) {
                DFS(list[node].get(i));
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited2[start] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < list[cur].size(); i++) {
                if (!visited2[list[cur].get(i)]) {
                    visited2[list[cur].get(i)] = true;
                    que.add(list[cur].get(i));
                }
            }
        }

    }
}
