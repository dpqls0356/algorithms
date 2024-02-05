
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que1 = new LinkedList<Integer>();
		for(int i=1;i<=N;i++)que1.add(i);
		
		Queue<Integer> que2 = new LinkedList<Integer>();
		int cnt = 1;
		System.out.print("<");
		while(!(que1.isEmpty())) {
			if(cnt%K==0) {
				sb.append(que1.poll()+", ");
			}
			else {
				que2.add(que1.poll());				
			}
			cnt++;
			if(que1.isEmpty()) {
				que1 = que2;
			}
			
		}

		String result = sb.toString();
		result = result.substring(0,result.length()-2);
		System.out.print(result);
		System.out.print(">");
	}
}
//LinkedList<Integer> list = new LinkedList<Integer>();
//for(int i=1;i<=N;i++) {
//	list.add(i);
//}
//boolean visited[] = new boolean [N];
//int cnt = 0; // 출력한 글자 수
//int add = 0;
//
//while(cnt!=N) {
//	//index = 0,1,2,3,4,5,6
//	if(add<N) {
//		if((add+1)%3==0&&!visited[add]) {
//			System.out.print(list.get(add));
//			visited[add] = true;
//			cnt++;
//		}
//		else {
//			add++;
//		}				
//	}
//	else
//		add=0;
////	System.out.println(index);
//}