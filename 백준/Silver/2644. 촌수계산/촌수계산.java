import java.util.*;
import java.io.*;
public class Main {
	
	public static int N, start, end;
	public static ArrayList<Integer> list[];
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int edge = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		BFS(start);
	}
	public static void BFS(int start) {
		// 다음위치 , count
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {start,0});
		visited[start] = true; 
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for(int i=0;i<list[cur[0]].size();i++) {
				if(list[cur[0]].get(i)==end) {
					System.out.println(cur[1]+1);
					return;
				}
				if(!visited[list[cur[0]].get(i)]) {
					que.add(new int[] {list[cur[0]].get(i),cur[1]+1});
					visited[list[cur[0]].get(i)] = true;
				}
			}
		}
		System.out.println("-1");
	}
}