import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = findCommonMultiple(A,B);
            sb.append(result+"\n");
        }
        System.out.print(sb.toString());
    }
    public static int findCommonMultiple(int A,int B){
        int i = 1;
        int k = 1;
        int small = A>B?B:A;
        int big = A>B?A:B;
        while(true){
            if(small*i==big*k)break;
            else {
                i++;
                if(big*k<small*i)k++;
            }
        }
        return small*i;
    }
}
