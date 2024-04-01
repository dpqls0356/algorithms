import java.util.*;
import java.io.*;

public class Main {
	public static boolean visited[] = new boolean[100001];
	public static int start,end;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		visited[start] = true;
		
		BFS();
	}
	public static void BFS() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {start,0});
		
		while(!que.isEmpty()) {
//			System.out.println("\n------------------------");
			int cur[] = que.poll();
			int num = cur[0];
			int cnt = cur[1];
			if(num==end) {
//				System.out.println(num+" "+cnt);
				System.out.println(cnt);
				return;
			}
//			System.out.print(num+" : ");
			if(num>end) {
				if(num-1>=0&&!visited[num-1]) {
					que.add(new int[] {num-1,cnt+1});
					visited[num-1]= true;
//					System.out.print((num-1)+" ");
				}
			}
			else {
				if(num-1>=0&&!visited[num-1]) {
					que.add(new int[] {num-1,cnt+1});
					visited[num-1]= true;
//					System.out.print((num-1)+" ");
				}
				if(num+1<100001&&!visited[num+1]) {
					que.add(new int[] {num+1,cnt+1});
					visited[num+1]= true;
//					System.out.print((num+1)+" ");
				}
				if(num*2<100001&&!visited[num*2]) {
					que.add(new int[] {num*2,cnt+1});
					visited[num*2]= true;
//					System.out.print((num*2)+" ");

				}
			}
		}
	}
}