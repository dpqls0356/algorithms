import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
//		for(int i=0;i<N;i++) {
//			System.out.print(i+" : ");
//			for(int k=0;k<list[i].size();k++) {
//				System.out.print(list[i].get(k)+" ");
//			}
//			System.out.println();
//		}
		for(int i=0;i<N;i++) {
			visited[i]= true;
			DFS(i,0);
			visited[i]=false;
		}
		System.out.println(0);
	}
	public static void DFS(int node,int depth) {
		
//		System.out.println(node+" "+depth);
		if(depth==4) {
			System.out.println(1);
			System.exit(0);
		}
		else {
			for(int i=0;i<list[node].size();i++) {
				if(!visited[list[node].get(i)]) {
//					System.out.println(node);
					visited[list[node].get(i)] = true;
					DFS(list[node].get(i),depth+1);
					visited[list[node].get(i)]= false;
				}
			}			
		}
	}
}
