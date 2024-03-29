import java.io.*;
import java.util.*;


public class Main {
	static int N,Edge,start;
	static ArrayList<Integer> list[];
	static boolean visitedBFS[];
	static boolean visitedDFS[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visitedBFS = new boolean[N+1];
		visitedDFS = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			list[i]  = new ArrayList<>();
		}
		for(int i=0;i<Edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i=0;i<N+1;i++) {
			Collections.sort(list[i]);
		}
		DFS(start);
		System.out.println();
		BFS(start);
	}
	public static void DFS(int node) {
		visitedDFS[node] = true;
		System.out.print(node+" ");
		for(int i=0;i<list[node].size();i++) {
			if(!visitedDFS[list[node].get(i)]){
				DFS(list[node].get(i));
			}
		}
	}
	public static void BFS(int node) {
		Queue<Integer> que = new LinkedList();
		que.add(node);
		visitedBFS[node] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int i=0;i<list[cur].size();i++) {
				if(!visitedBFS[list[cur].get(i)]) {
					que.add(list[cur].get(i));
					visitedBFS[list[cur].get(i)]=true;
				}
			}
		}		
	}
}