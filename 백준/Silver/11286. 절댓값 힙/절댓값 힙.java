
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> priorityQue = new PriorityQueue<>((o1,o2)->{
			int abs1 = Math.abs(o1);
			int abs2 =Math.abs(o2);
			if(abs1==abs2)return o1>o2?1:-1;
			else return abs1-abs2;
		});
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num==0) {
				if(priorityQue.isEmpty())sb.append(0+"\n");
				else sb.append(priorityQue.poll()+"\n");
			}
			else {
				priorityQue.add(num);
			}
		}
//		PriorityQueue<Integer> absPriorityQue = new PriorityQueue<>();
//		for(int i=0;i<N;i++) {
//			st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			if(num==0) {
//				if(priorityQue.isEmpty())sb.append(0+"\n");
//				else {
//					while(true) {
//						if(Math.abs(priorityQue.peek())==absPriorityQue.peek()) {							
//							sb.append(priorityQue.poll()+"\n");
//							absPriorityQue.poll();
//						}
//						else {
//							priorityQue.add(priorityQue.poll());
//						}
//					}
//				}
//			}
//			else {
//				System.out.print(".");
//				priorityQue.add(num);	
//				absPriorityQue.add(Math.abs(num));
//			}
//			// 재정의를 해야하는 흠 고민이네
//		}
		System.out.print(sb.toString());
	}
}
