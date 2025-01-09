import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        
        long answer = 0;
        
        for(int i=5;i<=N;i*=5){
            answer+=N/i;
        }

        System.out.print(answer);

    }


}
