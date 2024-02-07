import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int start=0; // 출발해야하는 방이 가진 수
	public static int maxCnt=1; // 최대 이동횟수 
	public static int cnt=1;
	public static int arr[][];
	public static int N;
	public static void main(String args[]) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<T+1;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for(int k=0;k<N;k++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			start =arr[0][0];
			maxCnt=1;
			cnt=1;
			for(int k=0;k<N;k++) {
				for(int j=0;j<N;j++) {
					cnt=1;
//					System.out.println("------"+k+" "+j+"------");
					find(arr[k][j],k,j); // 해당 수의 최대 이동 횟수를 구한다.
					if(cnt==maxCnt) {
						if(start>arr[k][j]) {
							start =arr[k][j];
						}
					}
					else if(cnt>maxCnt) {
						maxCnt = cnt;
						start =arr[k][j];
					}
				}
			}
			System.out.println("#"+i+" "+start+" "+maxCnt);
		}
		
	}
	public static void find(int before,int k,int j) {
		// 우 상 좌 하
		int dy[] = {0,1,0,-1};
		int dx[]= {1,0,-1,0};
		for(int i=0;i<4;i++) {
			int x = k+dx[i];
			int y = j+dy[i];
			if(x>=0&&x<N&&y>=0&&y<N) {
				int num = arr[x][y];
				if(num==before+1) {
					cnt++;
					find(num,x,y);
//					System.out.println("-"+(num-1)+" "+cnt);
					break;
				}
			
			}
		}
	}
}
