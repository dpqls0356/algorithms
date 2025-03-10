import java.io.*;
import java.util.*;
/*
1. 복사해서 클립보드에 저장, 단 다시 복사를 하면 이전 내용은 덮어쓰기 됨 => 저장된 것 n
2. 클립보드에 있는 이모티콘 화면에 붙여넣기 => cnt + n
3. 화면에 있는 이모티콘 중 하나를 삭제 => cnt -1

흠 복사 여부의 시간 저장 배열이랑 아닐 때를 나눠야하나
동일하겐 가져갈 수 없는데

*/
public class Main {
    private static int MAX_SIZE = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt(); // 끝점
        int start = 1; // 시작점
        int timeList[][] = new int[MAX_SIZE][MAX_SIZE]; // 해당 지점까지 시간과 복사된 이모티콘의 수 
        for(int i=0;i<MAX_SIZE;i++){
            for(int k=0;k<MAX_SIZE;k++){
                timeList[i][k] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1,0,0}); // 이모티콘 개수 , 복사 상황,시간
        timeList[1][0] = 0;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int cnt = cur[0];
            int copyState = cur[1];
            int time = cur[2];
            
            //이모티콘 개수가 맞는 경우
            if(cnt==end){
                System.out.print(time);
                return;
            }
            
            //복사
            if(cnt!=0&&time+1<timeList[cnt][cnt]){
                timeList[cnt][cnt] = time+1;
                que.add(new int[]{cnt,cnt,time+1});
            }
            
            //붙여넣기
            if(copyState!=0&&cnt+copyState<=1000&&time+1<timeList[cnt+copyState][copyState]){
                timeList[cnt+copyState][copyState] = time+1;
                que.add(new int[]{cnt+copyState,copyState,time+1});
            }
            //삭제
            if(cnt-1>0&&time+1<timeList[cnt-1][copyState]){
                timeList[cnt-1][copyState] = time+1;
                que.add(new int[]{cnt-1,copyState,time+1});
            }
            
        }
        
    }
}
