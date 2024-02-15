
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Node> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>(); // 방문처리용 hashmap, value는 사용하지 않으므로 0을 넣을 거임
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = sc.nextInt(); // 누나의 위치
        final int K = sc.nextInt(); // 동생의 위치

        if (K < N) { // 동생의 위치가 누나의 위치보다 작을 경우 무조건 -1을 계속하게 됨
            bw.append(N-K+"\n");
            for (int i = N; i >= K; i--) {
                bw.append(i + " ");
            }
            bw.flush();
            return;
        }
        
        // 동생의 위치가 누나의 위치보다 클 경우

        q.offer(new Node(N, N + "")); // 우선 누나의 위치를 큐에 넣음
        map.put(N, 0);    // 누나의 위치 방문 처리

        Node selectedNode = null;    // 답

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.position == K) {
                selectedNode = node;
                break;
            }

            if (!map.containsKey(node.position + 1) && node.position < K) { // 이전에 방문했으면 안가기
                q.offer(new Node(node.position + 1, node.prev + " " + (node.position + 1))); // 기존 위치에 +1
                map.put(node.position + 1, 0); // 방문처리
            }
            if (!map.containsKey(node.position - 1)) { // 이전에 방문했으면 안가기
                q.offer(new Node(node.position - 1, node.prev + " " + (node.position - 1))); // 기존 위치에 -1
                map.put(node.position - 1, 0); // 방문처리
            }
            if (!map.containsKey(node.position * 2) && node.position < K && node.position <= 50000) { // 이전에 방문했으면 안가기
                q.offer(new Node(node.position * 2, node.prev + " " + (node.position * 2))); // 기존 위치  X 2
                map.put(node.position * 2, 0);// 방문처리
            }
        }

        // 결과 출력
        String[] result = selectedNode.prev.split(" ");
        bw.append(result.length - 1 + "\n");// 가장 빠른시간
        for (String string : result) { // 이동해온 과정
            bw.append(string + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Node {
        int position;
        String prev;

        public Node(int position, String prev) {
            this.position = position;
            this.prev = prev;
        }

    }
}


