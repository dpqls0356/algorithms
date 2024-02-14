import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int A[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		st = new StringTokenizer(br.readLine());
		int findCnt = Integer.parseInt(st.nextToken());
		int findNum[] = new int [findCnt];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<findCnt;i++) {
			findNum[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<findCnt;i++) {
			if(Arrays.binarySearch(A, 0, A.length, findNum[i])>=0) {
				sb.append(1+"\n");
			}
			else sb.append(0+"\n");
		}
		System.out.println(sb);
	}
}
