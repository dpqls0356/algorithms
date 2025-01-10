import java.util.*;


public class Main {
    
    private static long cnt2 = 0;
    private static long cnt5 = 0;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long R = sc.nextLong();
        long other = N-R;
        
        cal(2,N,true);
        cal(2,R,false);
        cal(2,other,false);
        cal(5,N,true);
        cal(5,R,false);
        cal(5,other,false);
        
        long result = cnt2<cnt5?cnt2:cnt5;
        
        System.out.print(result);
    }
    
    public static void cal(long size,long num,boolean type){
        for(long i = size;i<=num;i*=size){
            if(type){
                if(size==2){
                    cnt2+=num/i; 
                }
                else{
                    cnt5+=num/i; 
                }

            }
            else{
                if(size==2){
                    cnt2-=num/i; 
                }
                else{
                    cnt5-=num/i; 
                }
            }
        }
    }
}
