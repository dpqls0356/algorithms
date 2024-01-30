
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2805 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int q = 0; q < T; q++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int k = 0; k < N; k++) {
					arr[i][k] = str.charAt(k) - '0';
				}
			}
			int result = 0;
			int reIndex = N / 2; // 2
			int len = 1;
			for (int i = 0; i <= N / 2; i++) {
				for (int k = 0; k < N; k++) {
					if (k >= reIndex && k < reIndex + len) { // 2 3
						result += arr[i][k];
					}
				}
				reIndex--;
				len += 2;
			}
			reIndex = N / 2;
			len = 1;
			for (int k = N - 1; k > N / 2; k--) {
				for (int i = 0; i < N; i++) {
					if (i >= reIndex && i < reIndex + len) {
						result += arr[k][i];
					}
				}
				reIndex--;
				len += 2;
			}
			System.out.println("#" + (q + 1) + " " + result);
		}
	}
}
