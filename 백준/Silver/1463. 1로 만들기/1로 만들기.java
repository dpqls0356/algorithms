import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int dp[] = new int[n+1];
		
		dp[0] = dp[1] = 0;
		if(n>1) {
			dp[2]=1;
		}
		if(n>2) {
			dp[3] = 1;			
		}
		int cur = 1;
		while(cur<=n) {
			int cnt;
			int minCnt = Integer.MAX_VALUE;
			if(cur<4) {
				cur++;
				continue;
			}
			if(cur%3==0) {
				cnt = (dp[cur/3]+1);
				if(minCnt>cnt)minCnt = cnt;
			}
			if(cur%2==0) {
				cnt = (dp[cur/2]+1);
				if(minCnt>cnt)minCnt = cnt;
			}
			cnt = dp[cur-1]+1;
			if(minCnt>cnt)minCnt = cnt;
			dp[cur] = minCnt;
			cur++;
		}
		System.out.print(dp[n]);
	}
}
