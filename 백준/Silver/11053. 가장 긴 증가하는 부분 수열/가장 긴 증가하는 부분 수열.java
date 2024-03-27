
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	//시간복잡도 n^2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int lis[] = new int[N+1];
		for(int i=1;i<N+1;i++) {
			lis[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i]&&lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
				}				
			}
		}
		Arrays.sort(lis);
		System.out.println(lis[lis.length-1]);
	}
	
}