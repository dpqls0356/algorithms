import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long min =  Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        
        //100이 들어오면 10까지만 소수구하기 -> 어차피 10*10이 100이기때문 11*11*n은 배수가 될 수 없음
        int range = (int)Math.sqrt(max);
        
        //소수 제곱근 해서 제곱ㄴㄴ의 수가 아닌 수 찾기 = 제곱으로 나누어떨어지는 친구 찾기
        //max-min 최대가 1,000,000인걸 고려
        boolean[] check = new boolean[(int)(max-min+1)];
        int count = 0;
        for(int i=2;i<=range;i++){
            long num = (long)Math.pow(i,2); // 제곱수
            long start = min/num; // 시작점, 만약 min이 8이고 num이 4이면 2부터 시작 , min이 6이고 num이 4이면 1부터 시작
            long end = max/num;
            for(long k = start;k<=end;k++){
                if(k*num>=min&&k*num<=max&&!check[(int)(k*num-min)]){
                    count++;
                    check[(int)(k*num-min)] = true;
                }
            }
        }
        
        System.out.print(max-min+1-count);
        
    }
}
