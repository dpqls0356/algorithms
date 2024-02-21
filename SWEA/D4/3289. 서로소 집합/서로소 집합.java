
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int parent[];
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<=T;tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			for(int i=1;i<=N;i++) {
				parent[i] = i;
			}
			for(int k=0;k<M;k++) {
                st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(cal == 0) {
					union(x,y);
				}
				else if(cal ==1) {
					if(Find(x)==Find(y)) {
						sb.append(1);
					}
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static int Find(int x) {
		return parent[x] = ( parent[x] == x?x:Find(parent[x]));
	}
	public static void union(int x,int y) {
		int xRoot = Find(x);
		int yRoot = Find(y);
		if(xRoot!=yRoot) {
			parent[yRoot] =xRoot;
		}
	}
}
