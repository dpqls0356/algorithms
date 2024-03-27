package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*인접행렬로 다익스트라 */
public class BJ1753_2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int arr[][] = new int[V + 1][V + 1];
        // 인접행렬 만들기 ...
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[startV][endV] = weight;
        }

        // 최단경로 찾기
        // 방문여부
        boolean visited[] = new boolean[V + 1];
        // 현재까지 최단경로를 담는 것
        int res[] = new int[V + 1];
        // 시작노드로부터 각 정점까지 비용 넣기
        visited[start] = true;
        for (int i = 1; i < V + 1; i++) {
            res[i] = arr[start][i];
        }
        for (int i = 1; i < V; i++) {
            // 방문하지않았고 가장 비용이 적은 것 고르기
            int min = Integer.MAX_VALUE;
            int minIndex = 1;
            for (int k = 1; k < V + 1; k++) {
                if (res[k] != 0 && !visited[k] && min > res[k]) {
                    min = res[k];
                    minIndex = k;
                }
            }
            visited[minIndex] = true;
            // System.out.println(minIndex);
            // 거쳐가는 경우를 고려해 최소비용 갱신
            for (int k = 1; k < V + 1; k++) {
                // start == k (start는 항상 0이어야한다.)
                // minIndex에서 해당 노드로 가는 게 없으면 그대로 놔두기
                if (start == k)
                    continue;
                else if (arr[minIndex][k] == 0)
                    continue;
                else if (res[k] == 0 || res[k] > res[minIndex] + arr[minIndex][k])
                    res[k] = res[minIndex] + arr[minIndex][k];

            }

        }

        // 결과 출력
        for (int i = 1; i < V + 1; i++) {
            if (start == i)
                sb.append(0 + "\n");
            else {
                if (res[i] == 0)
                    sb.append("INF\n");
                else
                    sb.append(res[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
