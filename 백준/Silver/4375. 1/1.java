import java.util.*;
import java.io.*;
/*
n의 배수 중 가장 작은 수의 자리수 출력
단 n의 배수는 모두 1로 이루어져있어야한다.
n=3 1 ; 1 -> 11 ; 2 -> 111; 0 37로 나누어 떨어짐 => 자리수는 3
n=7 1 ; 1 -> 11 ; 4 -> 111; 6 -> 1111; 5 -> 11111 -> 111111 -

조건1. 1의 개수는 n의 자리수 이상부터
조건2. 매번 1을 늘리면서 해야하는가 ? 

*/
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        
        while ((line = br.readLine()) != null) {  
            System.out.println(cal(Integer.parseInt(line)));
        }
        
    }
    
    public static long cal(int n){
        int num = 1;
        int length = 1;
        while(true){
            if(num%n == 0){
                return length;
            }
            else{
                length++;
                num = (((num * 10%n)%n) + (1%n))%n;
            }
        }
    }
}
