import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[cnt];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<cnt;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0;i<cnt;i++) {
			if(len>=arr[i])len++;
		}
		System.out.println(len);
	}
}
