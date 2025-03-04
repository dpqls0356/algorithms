import java.util.*;
import java.io.*;
/*
가중치가 다르지않음
단 길을 기록해야함...

*/
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int subeen = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        
        if(subeen == sister){
            System.out.print(0+"\n"+sister);
            return ;
        }
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[1]-b[1]);
        que.add(new int[]{subeen,0,});
        
        int timeList[] = new int[100_001];
        int routes[] = new int[100_001];
        for(int i=0;i<100_001;i++){
            timeList[i] = Integer.MAX_VALUE;
        }
        timeList[subeen] = 0;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int pos = cur[0]; // 현재 위치 
            int time = cur[1]; // 시간

            if(pos == sister){
                System.out.println(timeList[pos]);
                
                ArrayList<Integer> resultRoute = new ArrayList<>();
                int current = pos;
                while(current!=subeen){
                    resultRoute.add(current);
                    current = routes[current];
                }
                resultRoute.add(subeen);
                for(int i=resultRoute.size()-1;i>=0;i--){
                    System.out.print(resultRoute.get(i)+" ");
                }
                return;
            }
            if(pos*2<=100_000&&timeList[pos*2]>time+1){
                que.add(new int[]{pos*2,time+1});
                 timeList[pos*2] = time+1;
                 routes[pos*2] = pos;
            }
            if(pos+1<=100_000&&timeList[pos+1]>time+1){
                que.add(new int[]{pos+1,time+1});
                timeList[pos+1] = time+1;
                routes[pos+1] = pos;
            }
            if(pos-1>=0&&timeList[pos-1]>time+1){
                que.add(new int[]{pos-1,time+1});
                timeList[pos-1] = time+1;
                routes[pos-1] = pos;
            }

        }
    }
}
