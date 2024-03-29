import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];
	static ArrayList<Integer> list = new ArrayList<>();
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int k=0;k<N;k++) {
				map[i][k] = str.charAt(k)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int k=0;k<N;k++) {
				if(!visited[i][k]&&map[i][k]==1) {
					BFS(i,k);
				}
			} 
		}
		System.out.println(list.size());
        Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	public static void BFS(int curX,int curY) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {curX,curY});
		visited[curX][curY] = true;
		int count = 1;
		while(!que.isEmpty()) {
			int cur[] = que.poll();
			for(int i=0;i<4;i++) {
				int x = cur[0]+dx[i];
				int y=  cur[1]+dy[i];
				if((x<N&&x>=0&&y<N&&y>=0)&&!visited[x][y]&&map[x][y]==1) {
					visited[x][y] = true;
					map[x][y] = list.size()+1;
					que.add(new int[] {x,y});
					count++;
				}
			}
		}
		list.add(count);
	}
}