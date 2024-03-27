package BJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BJ13913 {
    public static class Node {
        int position;
        String preRoute;

        public Node(int position, String preRoute) {
            this.position = position;
            this.preRoute = preRoute;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        // 방문배열 대신 사용
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        Node selectedNode = null;
        map.put(N, 0);
        que.add(new Node(N, N + ""));
        if (K < N) {
            System.out.println(N - K);
            for (int i = N; i > K - 1; i--) {
                System.out.print(i + " ");
            }
            System.exit(0);
        }
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.position == K) {
                selectedNode = node;
                String route[] = selectedNode.preRoute.split(" ");
                System.out.println(route.length - 1);
                for (int i = 0; i < route.length; i++) {
                    System.out.print(route[i] + " ");
                }
            }

            if (!map.containsKey(node.position + 1) && node.position < K) {
                que.offer(new Node(node.position + 1, node.preRoute + " " + (node.position + 1))); // 기존 위치에 +1
                map.put(node.position + 1, 0); // 방문처리
            }
            // 이전에 방문했으면 안가기
            if (!map.containsKey(node.position - 1)) {
                que.offer(new Node(node.position - 1, node.preRoute + " " + (node.position - 1))); // 기존 위치에 -1
                map.put(node.position - 1, 0); // 방문처리
            }
            // 이전에 방문했으면 안가기 + 현재위치가 동생위치보다 크면 더하기 연산을 할 필요가 없으니 조건 걸어주기 + 현재위치가 50000이상이면
            // K의 조건을 넘어가는거라 조건 걸어주기[메모리 초과를 방지]
            if (!map.containsKey(node.position * 2) && node.position < K && node.position <= 50000) {
                que.offer(new Node(node.position * 2, node.preRoute + " " + (node.position * 2))); // 기존 위치 X 2
                map.put(node.position * 2, 0);// 방문처리
            }

        }

        // String route[] = selectedNode.preRoute.split(" ");
        // System.out.println(route.length - 1);
        // for (int i = 0; i < route.length; i++) {
        // System.out.print(route[i] + " ");
        // }
    }
}
