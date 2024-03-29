import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,Edge;
	static Queue<Integer> que = new LinkedList<>();
	static ArrayList<Integer> list[] ;
	static boolean visited[];
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Edge =Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<Edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		BFS();
		
		System.out.println(cnt);
		
	}
	public static void BFS() {
		que.add(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int i=0;i<list[cur].size();i++) {
				
				if(!visited[list[cur].get(i)]) {
					visited[list[cur].get(i)] = true;
					cnt++;
					que.add(list[cur].get(i));
				}
				
			}
			
		}
	}
}