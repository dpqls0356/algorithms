import java.util.*;
import java.io.*;

public class Main {

    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] isFinished; // 탐색 완료 여부
    private static int teamCount; // 팀원 수를 정확히 카운트할 변수

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            int person = Integer.parseInt(br.readLine());
            
            arr = new int[person + 1];
            visited = new boolean[person + 1];
            isFinished = new boolean[person + 1]; // 탐색이 끝났는지 체크
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= person; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            teamCount = 0; // 팀원 수 초기화
            for(int i = 1; i <= person; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
            
            sb.append(person - teamCount).append("\n"); // 팀원이 아닌 사람 수 출력
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) { // 아직 방문하지 않은 노드라면 DFS 탐색
            dfs(next);
        } else if (!isFinished[next]) { // 이미 방문한 노드지만, 탐색이 끝나지 않았다면 사이클 발생
            // 사이클 내 팀원 수 세기
            int cycleCount = 1;
            int temp = next;
            while (temp != cur) { // 사이클을 도는 동안 카운트
                cycleCount++;
                temp = arr[temp];
            }
            teamCount += cycleCount;
        }
        
        isFinished[cur] = true; // 현재 노드의 DFS 탐색이 끝났음을 표시
    }
}
