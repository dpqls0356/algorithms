import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K; //물건개수, 용량
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//물건의 개수
		K = Integer.parseInt(st.nextToken());	//최대용량
		int arr[][] = new int[N+1][K+1];
		int NW[] = new int [N+1];	//물건의 무게
		int NV[] = new int [N+1];	//물건의 가치
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			NW[i] = Integer.parseInt(st.nextToken());	//믈건의 무게 입력받기
			NV[i] = Integer.parseInt(st.nextToken());	//물건의 가치 입력받기
		}
		for(int i=0;i<N+1;i++) {
			arr[i][0] = 0;	// 최대용량이 0인 경우엔 0으로 설정
		}
		for(int i=0;i<K+1;i++) {
			arr[0][i] = 0;	// 물건을 넣지않는 경우엔 0으로 설정
		}
		for(int i=1;i<N+1;i++) {		//1번 물건부터 n번째 물건까지 넣는 경우
			for(int k=1;k<K+1;k++) {	//최대 용량이 1부터 K+1까지 
				if(NW[i]>k) {
					arr[i][k] = arr[i-1][k];
				}
				else {
					arr[i][k] = Math.max(arr[i-1][k], arr[i-1][k-NW[i]]+NV[i]);
				}
			}
		}
		System.out.println(arr[N][K]);
	}
}
