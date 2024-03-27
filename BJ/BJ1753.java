package BJ;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BJ1753 {
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int getto() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }

    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Edge> list[] = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        boolean visited[] = new boolean[V + 1];

        int start = Integer.parseInt(br.readLine());

        // 비용 초기화
        int price[] = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            price[i] = Integer.MAX_VALUE;
        }
        price[start] = 0;
        visited[start] = true;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Edge(to, weight));
            // 시작노드로부터 연결된 정점들의 가중치 업데이트하기
            if (from == start && price[to] > weight)
                price[to] = weight;
        }
        for (int i = 1; i <= V; i++) {
            // 가장 비용이 작은 것 찾기
            int minCost = Integer.MAX_VALUE;
            int minIndex = start;
            for (int k = 1; k <= V; k++) {
                if (!visited[k] && minCost > price[k]) {
                    minCost = price[k];
                    minIndex = k;
                }
            }
            visited[minIndex] = true;
            // System.out.println("-------" + minIndex + "-------");
            if (minIndex == start)
                break;
            for (int k = 0; k < list[minIndex].size(); k++) {
                // 최소비용의 노드와 연결된 엣지들 가져오기
                Edge obj = list[minIndex].get(k);
                // 나아가는 정점까지의 비용이 max_value면 가중치값 넣어주기
                // 나아가나는 정점까지의 비용이 max_value가 아니면 start에서 to까지 값과 start에서 min - > to까지 비용 비교해서
                // 업데이트
                if (price[obj.getto()] > price[minIndex] + obj.getWeight() || price[obj.getto()] == Integer.MAX_VALUE) {
                    price[obj.getto()] = price[minIndex] + obj.getWeight();
                }
            }
            // for (int a = 1; a < price.length; a++) {
            // System.out.print(price[a] + " ");
            // }
            // System.out.println();
        }
        for (int i = 1; i <= V; i++) {
            if (price[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(price[i] + "\n");
        }
        System.out.print(sb);
    }
}