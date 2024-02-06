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
		int R = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k=1;k<M+1;k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}
		for(int q=0;q<R;q++) {
			for(int i=1;i<Math.min(N, M)/2+1;i++) {
				int beforeNum = 0;
				int moveNum;
				//아래로 이동  
				for(int k=i;k<=N-i;k++ ) {
					if(k==i)
						beforeNum = arr[k][i];
					moveNum = arr[k+1][i];
//					System.out.println("!"+beforeNum+" "+ moveNum);
					arr[k+1][i] = beforeNum;
					beforeNum = moveNum;
				}
				//우으로 이동
				for(int k=i;k<=M-i;k++) {
					moveNum = arr[N-i+1][k+1];
//					System.out.println(beforeNum+" "+ moveNum);
					arr[N-i+1][k+1] = beforeNum;
					beforeNum = moveNum;
					
				}
				//위로이동
				for(int k=N-i;k>i-1;k--) {
					moveNum = arr[k][M-i+1];
//					System.out.println(beforeNum+" "+ moveNum);
					arr[k][M-i+1] = beforeNum;
					beforeNum = moveNum;
				}
				//왼쪽으로 이동
				for(int k=M-i;k>i-1;k--) {
					moveNum = arr[i][k];
//					System.out.println("-"+beforeNum+" "+ moveNum);
					arr[i][k] = beforeNum;
					beforeNum = moveNum;
				}
			}
			
		}
        			for(int i=1;i<=N;i++) {
				for(int k=1;k<=M;k++) {
					System.out.print(arr[i][k]+" ");
				}
				System.out.println();
			}
	}
}
