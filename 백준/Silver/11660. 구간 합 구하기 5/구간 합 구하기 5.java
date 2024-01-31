
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int S1[][] = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1;k<N+1;k++) {
				//가로
				S1[i][k] = S1[i][k-1]+Integer.parseInt(st.nextToken());
						}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int result =0;
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int k=x1;k<=x2;k++) {
				result += (S1[k][y2]-S1[k][y1-1]);
//				System.out.print(result +" ");
			}
			sb.append(result);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
