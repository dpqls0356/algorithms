import java.io.*;
import java.util.*;
 
class Point {
    int x;
    int y;
 
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class Main {
	static ArrayList<Point> spot;
	static ArrayList<Integer> list[];
	static int store;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=0;t<T;t++) {
			 
			//편의점 수
			st = new StringTokenizer(br.readLine());
			store = Integer.parseInt(st.nextToken());
			
			//편의점, 집, 페스티벌 위치를 담을 변수
			spot = new ArrayList<>();
			
			//편의점, 집, 페스티벌 위치 담기
			for(int i=0;i<store+2;i++) {
				st = new StringTokenizer(br.readLine());
				spot.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			
			//연결그래프 만들기 - 각 위치에서 갈 수 있는 point의 인덱스 값을 저장
			list= new ArrayList[store+2];
			for(int i=0;i<store+2;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<store+2;i++) {
				for(int k=i+1;k<store+2;k++) {
					if(Math.abs(spot.get(i).x-spot.get(k).x)+Math.abs(spot.get(i).y-spot.get(k).y)<=1000) {
						list[i].add(k);
						list[k].add(i);
					}
				}
			}
			if(BFS()) {
				System.out.println("happy");
			}
			else
				System.out.println("sad");
			
		}
	}
	public static boolean BFS() {
		boolean visited[] = new boolean[store+2];
		Queue<Integer> que = new ArrayDeque();
		que.add(0);
		visited[0] = true;
		
		while(!que.isEmpty()) {
			int curSpotIndex = que.poll();
			if(curSpotIndex==store+1)return true;
			else {
				for(int i = 0;i<list[curSpotIndex].size();i++) {
					if(!visited[list[curSpotIndex].get(i)]) {
						que.add(list[curSpotIndex].get(i));
						visited[list[curSpotIndex].get(i)] = true;
						
					}
				}
			}
		}
		return false;
	}
}