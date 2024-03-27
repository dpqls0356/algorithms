
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int memo[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			memo = new int[N+1];
			int idx=0;
			int len=0;
			for(int i=0;i<N;i++) {
				if(memo[len]<arr[i]) {
					len++;
					memo[len] = arr[i];
				}
				else {
					idx = BinarySearch(0, len, arr[i]);
					memo[idx] = arr[i];
					}	
				}
				System.out.println("#"+t+" "+len);
			}
		}
	public static int BinarySearch(int left,int right,int key) {
		int mid = 0;
		while(left<right) {
			mid = (left+right)/2;
			if(memo[mid]<key)left = mid+1;
			else {
				right = mid;
			}
		}
		return right;
	}
}
