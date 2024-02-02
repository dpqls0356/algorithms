
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		for(int i=1;i<N+1;i++) {
			q.add(i);
		}
		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}
}
