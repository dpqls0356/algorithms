
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int person = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int finder = Integer.parseInt(st.nextToken());
		int find = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list[]= new ArrayList[person+1];
		for(int i=1;i<person+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			  list[a].add(b);
			  list[b].add(a);
		}
		
		Queue<int[]> que = new LinkedList<>();
		boolean visited[] = new boolean[person+1];
		que.add(new int[] {finder,0});
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			if(cur[0]==find) {
				System.out.print(cur[1]);
				System.exit(0);
			}
			for(int move:list[cur[0]]) {
				if(!visited[move]) {
					visited[move]=true;
					que.add(new int[] {move,cur[1]+1});
				}
			}
		}
		System.out.println(-1);
	}
}
