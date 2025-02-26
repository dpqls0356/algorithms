import java.util.*;
import java.io.*;

public class Main {
    
    private static int[] arr;
    private static int[] state; // 0: 미방문, 1: 현재 탐색 중, 2: 팀 구성됨, 3: 팀 구성 불가
    private static int teamCount;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(st.nextToken());
        
        while(T > 0) {
            int person = Integer.parseInt(br.readLine());
            
            arr = new int[person+1];
            state = new int[person+1]; // 상태 배열 초기화
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<person+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            teamCount = 0;
            
            // 모든 학생에 대해 탐색
            for(int i=1; i<person+1; i++) {
                if(state[i] == 0) { // 아직 방문하지 않은 경우
                    dfs(i);
                }
            }
            
            sb.append(person - teamCount).append('\n');
            T--;
        }
        System.out.print(sb.toString());
    }
    
    public static void dfs(int node) {
        state[node] = 1; // 현재 탐색 중
        
        int next = arr[node];
        
         // 다음 노드가 아직 방문하지 않은 경우
        if(state[next] == 0) {
            dfs(next);
        }
        
        // 다음 노드가 현재 탐색 중인 경우 (사이클 발견)
        else if(state[next] == 1) { 
            // 사이클에 속한 노드 수 세기
            int count = 1;
            for(int i = next; i != node; i = arr[i]) {
                count++;
            }
            teamCount += count;
            
            // 사이클에 속한 노드들을 팀으로 표시
            int current = next;
            do {
                state[current] = 2; // 팀 구성됨
                current = arr[current];
            } while(current != next);
        }
        
        if(state[node] == 1) { // 아직 상태가 변경되지 않았다면
            state[node] = 3; // 팀 구성 불가로 표시
        }
    }
}