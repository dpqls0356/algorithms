import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int [][]cost = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<3;k++) {
				cost[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		int [][]sum = new int[N][3];
		int cur = 0;
		while(cur<N) {
			if(cur==0) {
				for(int i=0;i<3;i++) {
					sum[cur][i] = cost[cur][i];
				}
			}
			else {
				for(int i=0;i<3;i++) {
					if(i==0)sum[cur][i] = Math.min((cost[cur][0]+sum[cur-1][1]),(cost[cur][0]+sum[cur-1][2]));
					else if(i==1)sum[cur][i] =Math.min((cost[cur][1]+sum[cur-1][0]),(cost[cur][1]+sum[cur-1][2]));
					else if(i==2)sum[cur][i] =Math.min((cost[cur][2]+sum[cur-1][1]),(cost[cur][2]+sum[cur-1][0]));
				}
			}
			cur++;
		}
		System.out.println(Math.min(sum[N-1][0], Math.min(sum[N-1][1], sum[N-1][2])));
	}
}
