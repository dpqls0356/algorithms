import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String c;
        
        if(A>B)c=">";
        else if(A<B)c="<";
        else c = "==";
        
        System.out.print(c);
        
    }
}
