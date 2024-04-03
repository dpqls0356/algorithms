import java.util.*;
import java.io.*;

public class Solution {
	static int max,min;
	static int[] number;
	static int[] operator;
	static List<String> operatorList;  
	static int N;
	static char calStep[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			number = new int[N];
			operator = new int [4];
			operatorList = new ArrayList<String>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				operator[i] = Integer.parseInt(st.nextToken());
				switch(i) {
				case 0:
					for(int k=0;k<operator[i];k++) {
						operatorList.add("+");
					}
					break;
				case 1:
					for(int k=0;k<operator[i];k++) {
						operatorList.add("-");
					}
					break;
				case 2:
					for(int k=0;k<operator[i];k++) {
						operatorList.add("*");
					}
					break;
				case 3:
					for(int k=0;k<operator[i];k++) {
						operatorList.add("/");
					}
					break;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			calStep = new char[operatorList.size()];
			visited = new boolean[operatorList.size()];
			Cal(0);
			System.out.println("#"+t+" "+(max-min));
		}
	}
	public static void Cal(int depth) {
		if(depth==operatorList.size()) {
			int sum = number[0];
			int numberStep = 1;
			for(int i=0;i<calStep.length;i++) {
				switch(calStep[i]) {
				case '+':
					sum+=number[numberStep];
					break;
				case '-':
					sum-=number[numberStep];
					break;
				case '*':
					sum*=number[numberStep];
					break;
				case '/':
					if(sum==0)break;
					sum/=number[numberStep];
					break;
				}
				numberStep++;
			}
//			System.out.println(sum);
			if(max<sum)max = sum;
			if(min>sum)min = sum;
		}
		else {
			Set<String> checked = new HashSet<>();
			for(int i=0;i<operatorList.size();i++) {
				if(!visited[i]&&!checked.contains(operatorList.get(i))) {
					visited[i] = true;
					calStep[depth] = operatorList.get(i).charAt(0);
					Cal(depth+1);
					checked.add(operatorList.get(i));
					visited[i] = false;
				}
			}
		}
	}
}