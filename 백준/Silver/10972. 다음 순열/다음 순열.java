import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static int N;
	public static int arr[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N  = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		find();
	}
	public static void find() {
		int top = N-1;
		// 꼭대기 찾기
		while(top>0&&arr[top-1]>=arr[top]) {
			top--;
		}
		if(top==0) {
			System.out.print(-1);
			System.exit(0);
		}
//		System.out.println(top);
		int change = N-1;
		//바꾸는 위치 찾기
		while(arr[top-1]>=arr[change])change--;
		swap(top-1,change);
		Arrays.sort(arr,top,N);
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");	
		}
	}
	
	public static void swap(int top,int change) {
		int tmp = arr[top];
		arr[top] = arr[change];
		arr[change] = tmp;
	}
}
