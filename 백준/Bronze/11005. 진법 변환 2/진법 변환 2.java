import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextInt();
        int B = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        while(N>=B){
            long insertNum = N%B;
            if(insertNum >=10){
                sb.insert(0,(char)(insertNum+55));
            }
            else{
                sb.insert(0,insertNum);
            }
            N/=B;
        }
        if(N >=10){
            sb.insert(0,(char)(N+55));
        }
        else{
            sb.insert(0,N);
        }
        
        System.out.print(sb.toString());
    }
}
