
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Node selectedNode = null;
		Queue<Node> que = new ArrayDeque<>();
		Map<Integer, Integer> map =new HashMap<>();
		
		//동생이 더 낮은 위치에 있는 경우
		if(K<N) {
			sb.append(N-K+"\n");
			for(int i=N;i>=K;i--) {
				sb.append(i+" ");
			}
			System.out.print(sb);
			return;
		}
		
		
		que.add(new Node(N,N+""));
		map.put(N, 0); // 수빈의 위치 방문처리
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			// 동생을 찾은 경우
			if(node.pos==K) {
				selectedNode = node;
				break;
			}

            if (!map.containsKey(node.pos + 1) && node.pos < K) { // 이전에 방문했으면 안가기
                que.offer(new Node(node.pos + 1, node.pre + " " + (node.pos + 1))); // 기존 위치에 +1
                map.put(node.pos + 1, 0); // 방문처리
            }
            if (!map.containsKey(node.pos - 1)) { // 이전에 방문했으면 안가기
                que.offer(new Node(node.pos - 1, node.pre + " " + (node.pos - 1))); // 기존 위치에 -1
                map.put(node.pos - 1, 0); // 방문처리
            }
            if (!map.containsKey(node.pos * 2) && node.pos < K && node.pos <= 50000) { // 이전에 방문했으면 안가기
                que.offer(new Node(node.pos * 2, node.pre + " " + (node.pos * 2))); // 기존 위치  X 2
                map.put(node.pos * 2, 0);// 방문처리
            }
			
		}
		
		String res[] = selectedNode.pre.split(" ");
		sb.append(res.length-1+"\n");
		for(int i=0;i<res.length;i++) {
			sb.append(res[i]+" ");
		}
		System.out.print(sb);
	}
	 public static class Node{
		 // 경로 저장
		 String pre;
		 // 위치 저장
		 int pos;
		/**
		 * @param pre
		 * @param pos
		 */
		public Node(int pos,String pre) {
			super();
			this.pre = pre;
			this.pos = pos;
		}
		 
	 }
	 
}
