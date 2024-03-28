import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				for(int k=1;k<=N;k++) {
					arr[i][k] = Integer.parseInt(st.nextToken());
				}
			}
			//지도 초기화
			int map[][] = new int[N+1][N+1];
			for(int i=1;i<=N;i++) {
				for(int k=1;k<=N;k++) {
					if(arr[i][k]==0&&i!=k)map[i][k]=Integer.MAX_VALUE/2;
					else map[i][k] = arr[i][k];
				}
			}
			//플로이드 
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
				
			}
			int result[] = new int[N+1];
			for(int i=1;i<N+1;i++) {
				for(int k=1;k<N+1;k++) {
					result[i]+=map[i][k];
				}
			}
			Arrays.sort(result);
			sb.append("#"+t+" "+result[1]+"\n");
		}
		System.out.print(sb.toString());
	}
}


//			for(int i=1;i<=N;i++) {
//				for(int k=1;k<=N;k++) {
//					System.out.print(map[i][k]+" ");
//				}
//				System.out.println();
//			}
//			for(int num : result) {
//				System.out.println(num);
//			}