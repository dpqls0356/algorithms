import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ex2164{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> qu = new LinkedList<>();
        int i=1;
        while(i<=n){
            qu.add(i);
            i++;
        }

        while(qu.size()>1){
            qu.remove();
            int num = qu.poll();
            qu.add(num);
        }
        System.out.println(qu.peek());
    }
}