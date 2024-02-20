import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	static ArrayList<Integer> list[];
	static boolean visitedDfs[];
	static boolean visitedBfs[];
	static Queue<Integer> que = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a!=b) {
				list[a].add(b);
				list[b].add(a);
			}
			else 
				list[a].add(b);
		}
        for(int i=0;i<N+1;i++) {
			Collections.sort(list[i]);
		}
		DFS(V);
		System.out.println();
		visitedBfs[V] = true;
		que.add(V);
		BFS(V);
	}
	public static void DFS(int node) {
		if(!visitedDfs[node]) {
			visitedDfs[node]= true;
			System.out.print(node+" ");
			for(int i=0;i<list[node].size();i++) {
				if(!visitedDfs[list[node].get(i)]) {
					DFS(list[node].get(i));
				}
			}
		}
	}
	public static void BFS(int node) {
		while(!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur+" ");
			for(int i=0;i<list[cur].size();i++) {
				if(!visitedBfs[list[cur].get(i)]) {
					que.add(list[cur].get(i));
					visitedBfs[list[cur].get(i)] = true;
				}
			}
		}
	}
}
