
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void re(int cnt, String str,int beforeNum) {
		if(cnt>=M) {
			for(int i=0;i<M;i++) {
				System.out.print(str.charAt(i)+" ");				
			}
			System.out.println();
		}
		else {
			for(int i=beforeNum+1;i<=N;i++) {
				if(str.contains(Integer.toString(i))) {
					continue;
				}
				re(cnt+1,str+Integer.toString(i),i);
				str = str.substring(0, str.length());
			}
		}
			
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			String str = "";
			int cnt =1;
			str = str+Integer.toString(i);
			re(cnt,str,i);
		}
	}
}
