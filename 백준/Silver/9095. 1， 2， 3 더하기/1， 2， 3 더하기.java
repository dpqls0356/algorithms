import java.io.*;
import java.util.*;
/*
n이 주어짐
n부터 1자리까지 가능한 숫자들을 구함
-> 숫자를 구할때 n자리일때 사용 가능한 숫자의 범위 n-원하는 자리수 +1 
-> 여기서 숫자들을 정렬해서 해쉬셋이 이미 들어간 숫자 조합인지 판단
-> 이미 들어간 경우 빼기
-> 안들어간경우 중복이 있는 순열 !

*/
public class Main {
    
    private static int n;
    private static int cnt = 0;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        
        while(T>0){
            
            cnt=0;
            
            n = sc.nextInt();
            
            for(int i=1;i<=3;i++){
                dfs(i);
            }
            
            
            sb.append(cnt+"\n");
                
            T--;
        }
        
        System.out.print(sb.toString());
        
    }
    
    public static void dfs(int sum){
        if(sum==n){
            cnt++;
            return ;
        }
        else{
            for(int i=1;i<=3;i++){
                if(sum+i<=n){
                    dfs(sum+i);
                }
            }
        }
    }
}
