import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 수빈이의 위치
        int K = scanner.nextInt();  // 동생의 위치
        scanner.close();
        
        System.out.println(findShortestTime(N, K));
    }
    
    static class Position implements Comparable<Position> {
        int pos;    // 위치
        int time;   // 소요 시간
        
        public Position(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
        
        @Override
        public int compareTo(Position other) {
            return this.time - other.time;  // 시간 기준 오름차순 정렬
        }
    }
    
    public static int findShortestTime(int N, int K) {
        // 최대 위치 범위 설정
        int maxPos = 100000;
        
        // 방문 여부 체크 배열
        boolean[] visited = new boolean[maxPos + 1];
        
        // 우선순위 큐 생성 (시간이 적은 것이 우선)
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(N, 0));
        
        while (!pq.isEmpty()) {
            Position current = pq.poll();
            int pos = current.pos;
            int time = current.time;
            
            // 이미 방문한 위치면 스킵
            if (visited[pos]) {
                continue;
            }
            
            // 방문 표시
            visited[pos] = true;
            
            // 목표 위치에 도달한 경우
            if (pos == K) {
                return time;
            }
            
            // 순간이동 (0초 소요)
            if (pos * 2 <= maxPos && !visited[pos * 2]) {
                pq.offer(new Position(pos * 2, time));
            }
            
            // 왼쪽으로 이동 (1초 소요)
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                pq.offer(new Position(pos - 1, time + 1));
            }
            
            // 오른쪽으로 이동 (1초 소요)
            if (pos + 1 <= maxPos && !visited[pos + 1]) {
                pq.offer(new Position(pos + 1, time + 1));
            }
        }
        
        return -1;  // 도달할 수 없는 경우 (실제로는 발생하지 않음)
    }
}