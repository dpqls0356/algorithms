import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int sum = 0;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num<40){
                sum+=40;
            }else sum+=num;
        }
        System.out.print(sum/n);
    }
}
