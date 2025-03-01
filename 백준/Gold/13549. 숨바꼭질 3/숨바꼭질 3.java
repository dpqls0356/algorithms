import java.util.*;
import java.io.*;
/*
첫번째 풀었을때 틀림
 -> 1. 음 생각해보니 만약 0초에 도착할 수 있는데 
    큐 순서상 n초 후에 먼저 도착하고 그게 먼저 발견되어 결과로 출력될 수도 있겠다는 생각을 함
 -> 최솟값을 구하도록 바꿈
그래도 틀림 ㅋㅋ ㅜㅜ
 -> 아 도착지는 방문처리 하면 안되겠다 ! 
그래도 틀림 ㅋㅋ ㅜㅜ
 -> 아 복붙해서 조건을 잘못 줌 ㅜㅜ

 => 생각해보니 이렇게하면 방문배열에도 문제가 생길 것 같음

문제점은 잘 파악했으나 해결방법이 잘못 되었음 ...
1번 문제는 우선순위 큐를 사용해야함.. 그러면 항상 최단 시간이 앞에 배치되기때문에 방문배열처리도 고민하지않아도 된다.

인 줄 알았느나 이렇게 하면 안됨 ㅜ.ㅜ

방문배열 안쓰고 시간 기록 용 배열을 써야할 듯

*/

public class Main {
    
    private static int maxSize = 100_000;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int subeen = sc.nextInt();
        int sister = sc.nextInt();
        
        if(subeen == sister) {
            System.out.println(0);
            return;
        }
        
        int[] dist = new int[maxSize + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[subeen] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{subeen, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int time = cur[1];
            
            if(time > dist[pos]) continue;
            
            if(pos == sister) {
                System.out.println(time);
                return;
            }
            
            if(pos * 2 <= maxSize && time < dist[pos * 2]) {
                dist[pos * 2] = time;
                pq.add(new int[]{pos * 2, time});
            }
            
            if(pos - 1 >= 0 && time + 1 < dist[pos - 1]) {
                dist[pos - 1] = time + 1;
                pq.add(new int[]{pos - 1, time + 1});
            }
            
            if(pos + 1 <= maxSize && time + 1 < dist[pos + 1]) {
                dist[pos + 1] = time + 1;
                pq.add(new int[]{pos + 1, time + 1});
            }
        }
        
    }
}