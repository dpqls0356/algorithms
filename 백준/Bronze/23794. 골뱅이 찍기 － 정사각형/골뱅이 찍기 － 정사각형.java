import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=0;i<n+2;i++){
            // System.out.print("@");
            sb.append("@");
        }
        // System.out.println();
        sb.append("\n");
        for(int k=0;k<n;k++){
            for(int i=0;i<n+2;i++){
                if(i==0||i==n+1)
                    sb.append("@");
                    // System.out.print("@");
                else{
                    sb.append(" ");
                    // System.out.print(" ");
                }
            }
            sb.append("\n");  
        }
        // System.out.println();
        for(int i=0;i<n+2;i++){
            // System.out.print("@");
            sb.append("@");
        }
        
        System.out.print(sb.toString());
    }
}
