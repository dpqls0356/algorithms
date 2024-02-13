import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int win; //승리횟수
	public static int lose; //진 횟수
	public static int sumI; //인영이 합
	public static int sumG;  // 규영이 합
	public static boolean visited[]; // 카드 사용여부
	public static int gCard[] = new int[9]; // 규영이 카드 담아놓을 배열
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i=1;i<T+1;i++) {
			win = 0;
			lose = 0;
			sumI = 0;
			sumG = 0;
			visited = new boolean[19];
			st = new StringTokenizer(br.readLine());
			for(int k=0;k<9;k++) {
				int num = Integer.parseInt(st.nextToken());
				visited[num]=true;
				gCard[k]=num;
			}
			game(0);
			System.out.println("#"+i+" "+win+" "+lose);
		}
		
	}
	public static void game(int cardCnt) {
		if(cardCnt==9) {
			if(sumG<sumI)lose++;
			else win++;
		}
		else {
			for(int i=1;i<19;i++) {
				if(!visited[i]) {
					if(gCard[cardCnt]<i) {
						sumI +=(i+gCard[cardCnt]);
					}
					else {
						sumG +=(i+gCard[cardCnt]);
					}
					visited[i]= true;
					game(cardCnt+1);
					visited[i]=false;
					if(gCard[cardCnt]<i) {
						sumI -=(i+gCard[cardCnt]);
					}
					else {
						sumG -=(i+gCard[cardCnt]);
					}
				}
			}
		}
	}
}
