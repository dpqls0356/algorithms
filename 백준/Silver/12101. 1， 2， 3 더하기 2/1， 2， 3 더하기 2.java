import java.util.*;
import java.io.*;

public class Main {
    /*
        1,2,3 숫자를 중복으로 선택하여 순열을 만듦
        sum==n이고 count==k일 때 출력하고 멈추기
    */
    private static int n;
    private static int k;
    private static int count = 0;
    private static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        

        recrusive(0);
        System.out.println("-1");
        
    }
    public static void recrusive(int sum){
        if(sum == n ){
                count++;
            if(count == k){
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+"+");
                }
                System.out.println(list.get(list.size()-1));
                System.exit(0);
            }
        }else if(sum<n){
            for(int i=1;i<4;i++){
                list.add(i);
                recrusive(sum+i);
                list.remove(list.size()-1);
            }
        }
    }
}
