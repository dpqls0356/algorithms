import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<Integer> list[];
    public static int node;
    public static boolean visited[];
    public static int childParent[];

    public static void add(int parent, int child) {
        list[parent].add(child);
        list[child].add(parent);
    }

    public static void dfs(int curNode) {
        for (int i = 0; i < list[curNode].size(); i++) {
            int child = list[curNode].get(i);
            if (!visited[child]) {
                childParent[child] = curNode;
                visited[child] = true;
                dfs(child);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        list = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        childParent = new int[node + 1];
        visited[1] = true;
        for (int i = 1; i < node + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            add(parent, child);
        }
        dfs(1);
        for (int i = 2; i < node + 1; i++) {
            System.out.println(childParent[i]);
        }
    }
}